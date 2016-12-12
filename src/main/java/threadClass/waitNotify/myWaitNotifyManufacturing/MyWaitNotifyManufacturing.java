package threadClass.waitNotify.myWaitNotifyManufacturing;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ежище on 23.11.2016.
 * Задача: Рабочий спит неопределенное время (не более 500мс), затем производит болванку за 50мс, подписывает ее
 * числом - порядковым номером, кладет на конвейер и засыпает снова. Иногда (примерно в трети случаев, но без
 * закономерности) ему лень становиться за станок, он хитрит и подкладывает вместо болванки пустую бутылку, которая
 * похожа по форме, но сделана из стекла, а не металла (объект другого типа). Бутылку он также нумерует по порядку,
 * но времени на "производство" не тратит.
 * <p>
 * Когда он произвел 3 болванки, просыпается Грузчик и относит их на склад. Поскольку первой к Грузчику подъезжает
 * по конвейеру та болванка, которую Рабочий произвел раньше, он относит их в том же порядке, в каком их произвел
 * Рабочий. В это время Рабочий не прекращает работать или спать (правда, пока конвейер занят грузчиком, ему придется
 * подождать). Грузчик снова идет спать, перед этим решив, сколько болванок он отнесет в следующий раз
 * (больше 2, но меньше 6). У него чуйка, он просыпается, когда болванок ровно столько, сколько он задумал.
 * <p>
 * Грузчику все равно, что он несет, он неграмотный. А вот Кладовщик должен отделить зерна от плевел, выкинуть бутылки
 * в специальный мусорный бак и отправить 4 машины по 5 болванок в каждой, полупустые машины отправлять нельзя.
 * Машины все уже готовы и стоят ждут, очередь они не соблюдают. Они должны отвезти болванки на удаленный склад и там
 * их и оставить.
 * После отправки машин Кладовщик должен остановить производство болванок, побудить Грузчика принести на склад последние
 * оставшиеся болванки-бутылки и отправить рабочего с грузчиком спать домой совсем (производство закончено), а
 * также записать, сколько всего времени было потрачено на производство, сколько болванок осталось на складе,
 * сколько бутылок было подложено и с каким порядковым номером.
 * Болванки и бутылки отправляются на склад, в машины и в мусорку в виде объектов соответствующего класса
 * с соответствующим порядковым номером, который был дан им рабочим.
 * Можно в консоли или попробовать в окне. Если в консоли, то все действия по ходу их выполнения выводятся на печать.
 * PS "не прекращает работать" - это похоже на использование для добавления в хранилище java.util.concurrent или
 * java.util.concurrent.atomic, или же просто на synchronized с wait-notify, или на Semaphore.
 */
public class MyWaitNotifyManufacturing {
    /**
     * сколько болванок Грузчик решает отправить на склад в этот раз (первоначально 3):
     */
    private volatile int countOfBarsToSendToStorage,
    /**
     * время, затраченное на производство:
     */
    wholeTimeToManufacturing;
    /**
     * конвейер, на который Рабочий складывает произведенные болванки и бутылки, и откуда Грузчик их забирает:
     */
    private static ConcurrentLinkedDeque conveyor = new ConcurrentLinkedDeque(); // это хранилище не обязано быть
    // из пакета concurrent, поскольку к нему обращаются только 2 потока и строго по очереди, через объект Lock.
    /**
     * склад с болванками, из которых еще нужно выбрать бутылки:
     */
    private LinkedList stock = new LinkedList();
    /**
     * специальный мусорный бак для бутылок:
     */
    private Map<Integer, String> trashBin = new HashMap<>();
    /**
     * продолжается или закончено производство
     */
    private volatile static boolean workingDay;
    /**
     * блокиратор для работы с конвейером:
     */
    private ReentrantLock locker;
    /**
     * условие для блокиратора:
     */
    private Condition condition;
    /**
     * семафор-блокиратор для работы со складом:
     */
    private Semaphore semaphore;
    /**
     * флажок, чтобы пометить пополнение на складе:
     */
    private boolean stockRefilled;
    /**
     * Объект для синхронизации действий Кладовщика и Грузовиков на складе:
     */
    private static final Object stockMonitor = new Object();
    /**
     * Полка, на которую Кладовщик будет откладывать отсортированные болванки, в которых он уверен.
     * NB! Когда Кладовщик загрузил полку и открывает к ней доступ, за груз на ней начинают бороться сразу
     * 4 Грузовика, так что здесь следует принять меры по потокобезопасной работе со списком, например, так:
     */
    private CopyOnWriteArrayList<Object> shelf = new CopyOnWriteArrayList<>();
    // Хотя в данном случае в этом нет нужды - здесь в коде доступ к полке синхронизирован через wait/notify,
    // так что работает и так:
    // private ArrayList<Object> shelf = new ArrayList<>(); //TODO: попробовать воспользоваться CopyOnWriteArrayList
    // без синхронизации - по идее, должно сработать
    /**
     * Количество отправленных грузовиков - на всякий случай Atomic, поскольку будет осуществляться инкрементация
     * этого поля в разных потоках:
     */
    private AtomicInteger sentTrucksNumber;

// _______________________________________________________________________________________________________________

    public MyWaitNotifyManufacturing() {
        // при создании объекта класса в конструкторе сразу создаем блокиратор и условие для него - этот блокиратор
        // предназначен для работы с конвейером, будет открывать-закрывать к нему доступ:
        locker = new ReentrantLock();
        condition = locker.newCondition();
        // а вот семафор - это для доступа на склад:
        semaphore = new Semaphore(1); // (permits = 1, поскольку только 1 поток одновременно будет работать
        // на складе).
        // флажок о том, что на склад доставлены новые болванки, пока опущен:
        stockRefilled = false;
        // по условию, вначале грузчику нужно отнести на склад 3 болванки:
        countOfBarsToSendToStorage = 3;
        // рабочий день начинается:
        workingDay = true;
        // пока что еще не потрачено ни миллисекунды на производство:
        wholeTimeToManufacturing = 0;
        // и пока не отправлено ни одного грузовика:
        sentTrucksNumber = new AtomicInteger(0);
    }

    public static void main(String[] args) {
        MyWaitNotifyManufacturing manufacturing = new MyWaitNotifyManufacturing();
// ----------------------------------------------------------------------------------------------------
//        Worker worker = manufacturing.new Worker(); // полная форма записи для внутреннего (не-анонимного)
//        //  класса: MyWaitNotifyManufacturing.Worker worker = manufacturing.new Worker();
// ----------------------------------------------------------------------------------------------------
        // Для Runnable, кажется, без разницы, как запускать потоки, например:
        ExecutorService ex = Executors.newFixedThreadPool(7);
        // Рабочий запущен:
        ex.submit(manufacturing.worker); // для Runnable не знаю, в чем разница между submit и execute
        // Грузчик запущен:
        ex.execute(manufacturing.loader);
        // Кладовщик запущен:
        ex.execute(manufacturing.stockman);
        // Запускаем 4 Грузовика:
        for (int i = 0; i < 4; i++) {
            ex.execute(manufacturing.truck);
        }
        // По окончании работы, всех закрываем:
        ex.shutdown();
// ----------------------------------------------------------------------------------------------------
        // Можно было и так:
//        Thread workerWorks = new Thread(manufacturing.worker);
//        Thread loaderLoad = new Thread(manufacturing.loader);
//        Thread stockmanHandles = new Thread(manufacturing.stockman);
//        workerWorks.start();
//        loaderLoad.start();
//        stockmanHandles.start();
// ---------------------------------------------------------------------------------------------------------
//         // джойны - они нужны, если в main еще что-то должно быть выполнено после запуска потоков.
//        try {
//            workerWorks.join();
//            loaderLoad.join();
//            stockmanHandles.join();
//        } catch (InterruptedException e) {
//            workerWorks.interrupt();
//            e.printStackTrace();
//        }
// --------------------------------------------------------------------------------------------------------
        // Например, если main должен выполнить следующее:
//        System.out.println("Рабочий посылает на склад:");
//        for (Object bar : conveyor) {
//            if (bar.getClass().equals(Integer.class))
//                System.out.printf("bar %s, ", String.valueOf(bar));
//            else if (bar.getClass().equals(String.class))
//                System.out.printf("BOTTLE%s, ", bar);
//        }
    }
// ______________________________________________________________________________________________________________

    // Здесь использованы лямбды как заменители анонимного класса. Я решил не выносить создание потоков в отдельные
    // классы, использовал внутренние анонимные вида:
//    Runnable worker = new Runnable() {
//        @Override
//        public void run() {
//
//        }
//    };
    // а они легко заменяются лямбдами.

    public Runnable worker = () -> { // это Рабочий
        // Что нужно Рабочему для работы?
        // Номер текущей болванки:
        int currentBarNumber = 1;
        Random randomizer = new Random();
        // Случайное (но в обозначенных границах) время для сна:
        int timeToSleep = randomizer.nextInt(500);
        // Случайный номер для замены болванки бутылкой:
        boolean bottleInsteadOfBar = randomizer.nextInt(3) == 2;
        // Имя:
        Thread.currentThread().setName("Worker");
        System.out.printf("Рабочий %s приступил к работе!\n", Thread.currentThread().getName());
        // Рабочий работает, пока рабочий день не закончен:
        while (workingDay) {
            try {
                    Thread.sleep(timeToSleep); // sleep() is static. Quote from Java docs: "Thread.sleep causes
                    // the current thread to suspend execution for a specified period."
                    // (https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html), so no need
                    // to write Thread.currentThread().sleep(...);
                    // Замеряем время работы для того, чтобы Кладовщик по окончании рабочего дня взял эти данные:
                    wholeTimeToManufacturing += timeToSleep;
                // Рабочий блокирует для себя конвейер - это нечто вроде заменителя блока synchronized,
                // заканчивается на unlock():
                locker.lock();
                while (conveyor.size() >= countOfBarsToSendToStorage) {
                    // Когда болванок на конвейере болванок столько, сколько Грузчик загадал забрать, Рабочий
                    // теряет возможность класть новые, пока Грузчик не забрал уже положенные.
                    // await() работает так же, как wait() - если на конвейере болванок больше определенного
                    // количества, доступ Рабочему к фрагменту кода между condition.await() и locker.unlock() закрыт.
                    condition.await();
                }

//===============================================
                // Первым делом - условие окончания цикла. Грузовики проверяют склад на наличие нужного количества
                // болванок на полке сразу после того, как Кладовщик объявляет notify на полку - т.е. отпустит полку из
                // своей блокировки. В это время Рабочий находится внутри цикла while(workingDay), но спит,
                // блокированный замком locker.lock() (он передал Грузчику доступ к конвейеру через этот замок
                // несколькими строчками выше, когда сделал достаточное количество деталей:
                // conveyor.size() >= countOfBarsToSendToStorage   - и пока что спит). Но в это время Грузчик успел
                // отнести на склад все предметы с конвейера, так что для него теперь выполняется его собственное
                // условие блокировки conveyor.size() < countOfBarsToSendToStorage, и он также спит под этим локом
                // locker.lock(). Если сейчас Рабочий просто выскочит из цикла while(workingDay) через break, то Грузчик
                // по-прежнему будет заблокирован, и программа повиснет.
                // Поэтому снимаем блокировку с Грузчика через condition.signalAll() и выводим Рабочего из цикла
                // while(workingDay) через break:
                if(!workingDay) {
                    condition.signalAll();
                    break;
                }
//===============================================
                // А вот если предыдущее условие conveyor.size() >= countOfBarsToSendToStorage ложно,
                // дальнейший код выполняется:
                if (!bottleInsteadOfBar) {
                        Thread.sleep(50);
                    wholeTimeToManufacturing += 50;
                    // Рабочий кладет на конвейер болванку:
                    conveyor.offer(currentBarNumber); // добавление в конец очереди
                    System.out.printf("Рабочий %s спал %dмс, затем проснулся и за 50мс сделал болванку с порядковым" +
                            " номером %d\n", Thread.currentThread().getName(), timeToSleep, currentBarNumber);
                } else {
                    // Или бутылку:
                    conveyor.offer(String.valueOf(currentBarNumber));
                    System.out.printf("Рабочий %s спал %dмс, затем проснулся и вместо работы подложил на конвейер пустую" +
                                    " бутылку с порядковым номером %s\n", Thread.currentThread().getName(), timeToSleep,
                            String.valueOf(currentBarNumber));
                }
                // И объявляет о том, что конвейер снова доступен для всех, у кого есть разрешение им овладеть (или,
                // кстати, также для тех, кто захочет это сделать без разрешения):
                condition.signalAll(); //(это сигнал о том, что блокировка с конвейера снята и можно забрать детали, если
                // Грузчику позволяет его собственное условие. Если нет - Рабочий будет класть болванки на конвейер,
                // пока их количество не достигнет countOfBarsToSendToStorage).
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } finally { // обязательное условие для разблокировки ресурса в любом случае, поэтому в блоке finally
                locker.unlock();
            }
            // определяет номер следующей по порядку болванки:
            currentBarNumber++;
            // определяет, сколько он сейчас будет спать:
            timeToSleep = randomizer.nextInt(500);
            // положит ли он в следующий раз болванку или бутылку:
            bottleInsteadOfBar = randomizer.nextInt(3) == 2;
        }
        System.out.printf("Рабочий %s остановлен!\n", Thread.currentThread().getName());
    };
// ______________________________________________________________________________________________________

    public Runnable loader = () -> { // это Грузчик
        // Что нужно Грузчику?:
        // а почти ничего собственного-локального, кроме имени и рандомайзера - он аскет:
        Random randomizer = new Random();
        Thread.currentThread().setName("Loader");
        System.out.printf("Грузчик %s приступил к работе!\n", Thread.currentThread().getName());
        System.out.printf("Грузчик %s собирается отнести на склад охапку из %d предметов и пока пошел спать.\n",
                Thread.currentThread().getName(), countOfBarsToSendToStorage);
        while (workingDay) {
            locker.lock(); // (- отсюда начинается область действия блокировки конвейера)
            try {
                // Пока на конвейере нет нужного количества болванок и рабочий день еще не закончен, Грузчик спит:
                while (conveyor.size() < countOfBarsToSendToStorage && workingDay) {
                    condition.await();
                }
                // поле, чтобы проверить, сколько болванок в этом цикле while (workingDay) отнесет Грузчик:
                int shippedOnStorageThisTime = 0;
                // Просыпаясь, Грузчик берет болванки с конвейера в порядке от первой к последней, чтобы отнести их
                // на склад. Он захватывает доступ на склад с помощью семафора (если Кладовщик не успел еще сделать
                // этого, но Кладовщик сможет это сделать только после того, как Грузчик поднимет флажок - даже если
                // Кладовщик запустится раньше Грузчика - а флажок пока опущен). Метод acquire() означает, что все,
                // что под ним и до release(), будет выполняться, пока верно поставленное там условие, а если уже нет -
                // ресурсы освобождаются для других потоков.
                semaphore.acquire(); // (acquire() бросает InterruptedException, но мы уже внутри блока try,
                // который его отлавливает)
                while (!conveyor.isEmpty()) {
                    // Считаем, сколько предметов он берет с конвейера:
                    ++shippedOnStorageThisTime;
                    // Грузчик загружает на склад то, что он берет с конвейера:
                    stock.offer(conveyor.pop());
                }
                // После загрузки всего содержимого конвейера на склад он освобождает доступ на склад:
                semaphore.release();
                // и поднимает флажок как знак Кладовщику, что он что-то принес:
                stockRefilled = true;
                // затем выбирает, сколько болванок нести в следующий раз:
                countOfBarsToSendToStorage = randomizer.nextInt(5) + 2;
                // и сигнализирует, что он освободил конвейер. signalAll() применяется на случай, если больше двух
                // потоков будут использовать лок; если потоков с локом только два, достаточно использовать signal().
                condition.signalAll();
                if (workingDay)
                    System.out.printf("Грузчик %s отнес на склад %d предметов с конвейера, решил, что в следующий раз " +
                                    "отнесет охапку из %d предметов, и пошел спать.\n", Thread.currentThread().getName(),
                            shippedOnStorageThisTime, countOfBarsToSendToStorage);
                else
                    System.out.printf("Грузчик %s идет досыпать домой!\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } finally {
                locker.unlock(); // блокировка конвейера снята
            }
        }
    };
//_______________________________________________________________________________________________________________

    public Runnable stockman = () -> { // это Кладовщик
        // Что нужно Кладовщику?:
        int index = 1; // (счетчик бутылок в мусорке)
        Object temp = new Object(); // (неизвестный пока объект, извлеченный Кладовщиком со склада)
        Thread.currentThread().setName("Stockman");
        System.out.printf("Кладовщик %s приступил к работе!\n", Thread.currentThread().getName());
        // locker использовался Рабочим и Грузчиком для проверки занятости конвейера, но здесь Кладовщик использует его,
        // чтобы поспать, пока в конце рабочего дня не нужно будет записать wholeTimeToManufacturing и прочее:
        locker.lock();
        try {
            while (workingDay) {
                condition.await();
                // Но вот во сне Кладовщик замечает поднятый Грузчиком флажок:
                while (stockRefilled) {
                    // и проверяет, свободен ли доступ на склад. И если свободен, захватывает общий реурс (склад)
                    // в следующем за acquire() участке кода:
                    semaphore.acquire(); // acquire() throws InterruptedException, но оно уже отловлено здесь
                    // перебирает и проверяет то, что принес Грузчик: болванки оставляет, бутылки - в мусорку:
                    while (!stock.isEmpty()) {
                        temp = stock.poll(); // (перебирает с головы, с первого элемента, принесенного Грузчиком).
                        if (temp.getClass().equals(String.class)) {
                            trashBin.put(index, "бутылка" + temp); // хотя temp - это Object, но здесь автоматически
                            // применяется toString, так что нет нужды делать приведение (String)temp.
                            index++;
                        } else if (temp.getClass().equals(Integer.class)) {
                            shelf.add(temp);
                        }
                    }
                    System.out.println("map size = " + trashBin.size());
                    if (shelf.size() != 0)
                        System.out.println("После добавления на полке лежат болванки: " + shelf);
                    // и затем опускает флажок на складе:
                    stockRefilled = false;
                    // и освобождает доступ на склад:
                    semaphore.release();
                }
                // Кладовщик проверяет, достаточно ли болванок осталось на полке после чистки того, что принес на склад
                // Грузчик, и если да, то дает доступ к полке одной из ожидающих машин (какая первой окажется рядом),
                // а сам впадает в транс, пока Грузовики не освободят полку и не объявят, что болванок на полке меньше
                // пяти и можно класть еще:
                synchronized (stockMonitor) {
                    if (shelf.size() >= 5) {
                        stockMonitor.notifyAll();
                        stockMonitor.wait();
                    }
                }
                // К тому времени, как Грузовики разрешат Кладовщику выйти из транса, может оказаться, что очередной
                // Грузовик просигнализировал, что он был 4-ым, и рабочий день окончен. В этом случае Кладовщик выйдет
                // из данного цикла while(workingDay) и перейдет к подсчетам и окончанию своей работы.
            }
            // Кладовщик выскочил из цикла рабочего дня и может записать все, что должен:
            System.out.println("На полке склада осталось " + shelf.size() + " болванок с порядковыми номерами " + shelf);
            System.out.printf("Всего было сделано %d полноценных болванок. \nВ мусорку отправлены следующие объекты, " +
                    "найденные на конвейере под видом болванок:\n", shelf.size() + 20);
            for (Map.Entry<Integer, String> item : trashBin.entrySet())
                System.out.print(item.getValue() + ", ");
            System.out.printf("\nВсего в мусорку выкинуто %d бутылок.\n", trashBin.size());
            System.out.println("Затрачено на производство: wholeTimeToManufacturing = " + wholeTimeToManufacturing
            + "\nКладовщик запер склад и отправился домой!");
            // Что интересно, в следующей записи уже нет нужды, поскольку все общие ресурсы уже использованы
            // заинтересованными сторонами:
//            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    };
//____________________________________________________________________________________________________________

    public Runnable truck = () -> { // это Грузовики
        System.out.printf("Грузовик %s подъехал!\n", Thread.currentThread().getName());
        // Пока деталей на полке склада недостаточно, Грузовик ждет:
        synchronized (stockMonitor) {
            while (shelf.size() < 5) {
                try {
                    stockMonitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // А как только деталей стало достаточно (притом деталей может быть и 10 - на два Грузовика!), Грузовик
            // увозит 5 болванок:
            if (shelf.size() >= 5) {
                System.out.println(" Truck" + Thread.currentThread().getName() + ": enough number of bars!");
                for (int i = 0; i < 5; i++) {
                    shelf.remove(0); // NB: при каждом проходе цикла длина списка уменьшается на 1, соответственно
                    // сдвигаются индексы элементов, так что запись shelf.remove(i) через несколько проходов цикла
                    // вызовет ArrayIndexOutOfBoundsException
                }
            }
            // Грузовик заявляет о том, что он уехал, увеличивапя счетчик отправленных грузовиков:
            sentTrucksNumber.incrementAndGet();
            //================================================
            // и проверяет: если он был уже 4-ым, тогда он объявляет, что рабочий день окончен:
            if (sentTrucksNumber.get() == 4) {
                workingDay = false;
                System.out.println("Последний Грузовик был загружен и уехал!");
            }
            //=====================================================
            System.out.println("Грузовик " + Thread.currentThread().getName() + " забрал 5 болванок. На полке " +
                    "остались болванки с номерами: " + shelf);
            // И потом он освобождает доступ к полке:
            stockMonitor.notifyAll();
        }

    };
}
