package threadClass.waitNotify.myWaitNotifyManufacturing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
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
    public static ConcurrentLinkedDeque conveyor = new ConcurrentLinkedDeque(); // это хранилище не обязано быть
    // из пакета concurrent, поскольку к нему обращаются только 2 потока и строго по очереди, через объект Lock.
    /**
     * склад с болванками, из которых еще нужно выбрать бутылки:
     */
    public LinkedList stock = new LinkedList();
    /**
     * специальный мусорный бак для бутылок:
     */
    public Map<Integer, String> trashBin = new HashMap<>();
    /**
     * продолжается или закончено производство
     */
    private static boolean workingDay;
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
    /** Объект для синхронизации действий Кладовщика и Грузовиков на складе: */
    public static final Object stockMonitor = new Object();

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
    }

    public static void main(String[] args) {
        MyWaitNotifyManufacturing manufacturing = new MyWaitNotifyManufacturing();
// ----------------------------------------------------------------------------------------------------
//        Worker worker = manufacturing.new Worker(); // полная форма записи для внутреннего (не-анонимного)
//        //  класса: MyWaitNotifyManufacturing.Worker worker = manufacturing.new Worker();
// ----------------------------------------------------------------------------------------------------
        // Для Runnable, кажется, без разницы, как запускать потоки, например:
        ExecutorService ex = Executors.newFixedThreadPool(4);
        // Рабочий запущен:
        ex.submit(manufacturing.worker); // для Runnable не знаю, в чем разница между submit и execute
        // Грузчик запущен:
        ex.execute(manufacturing.loader);
        // Кладовщик запущен:
        ex.execute(manufacturing.stockman);
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
//        try {
//            workerWorks.join(); // джойны нужны, если в main еще что-то должно быть выполнено после запуска потоков.
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
        System.out.printf("Рабочий %s запущен!\n", Thread.currentThread().getName());
        while (workingDay) {
            try {
                Thread.sleep(timeToSleep); // sleep() is static. Java docs: "Thread.sleep causes the current thread
                // to suspend execution for a specified period." (https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html)
                // so no need to write Thread.currentThread().sleep(...);
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
                // А вот если предыдущее условие ложно, дальнейший код выполняется:
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
            if (currentBarNumber == 21) {
                workingDay = false;
            }
        }
        System.out.printf("Рабочий %s остановлен!\n", Thread.currentThread().getName());
    };

    public Runnable loader = () -> { // это Грузчик
        Thread.currentThread().setName("Loader");
        System.out.printf("Грузчик %s собирается отнести на склад охапку из %d болванок и пока пошел спать.\n",
                Thread.currentThread().getName(), countOfBarsToSendToStorage);
        Random randomizer = new Random();
        while (workingDay) {
            locker.lock();
            try {
                while (conveyor.size() < countOfBarsToSendToStorage && workingDay) {
                    // пока на конвейере нет нужного количества болванок и рабочий день еще не закончен, Грузчик спит.
                    condition.await();
                }
                // поле, чтобы проверить, сколько болванок отнесет Грузчик - в конце производства на конвейере может
                // остаться меньше болванок, чем он собирался отнести, и он должен будет отчитаться об этом:
                int shippedOnStorageThisTime = 0;
                // просыпаясь, грузчик берет болванки с конвейера в порядке от первой к последней, чтобы отнести их
                // на склад:
                while (!conveyor.isEmpty()) {
                    // Считаем, сколько предметов он берет с конвейера:
                    ++shippedOnStorageThisTime;
                    // Грузчик захватывает доступ на склад (если Кладовщик не успел еще сделать этого, но Кладовщик
                    // будет запущен позже):
                    semaphore.acquire(); // (acquire() бросает InterruptedException, но мы уже внутри блока try,
                    // который его отлавливает)
                    // и загружает туда то, что он берет с конвейера:
                    stock.offer(conveyor.pop());
                    // а потом освобождает доступ на склад:
                    semaphore.release();
                }
                // и поднимает флажок как знак Кладовщику, что он что-то принес:
                stockRefilled = true;
                // затем выбирает, сколько болванок нести в следующий раз:
                countOfBarsToSendToStorage = randomizer.nextInt(5) + 2;
                // и сигнализирует, что он освободил конвейер. signalAll() применяется на случай, если больше двух
                // потоков будут использовать лок; если потоков с локом только два, достаточно использовать signal().
                condition.signalAll();
                if (workingDay)
                    System.out.printf("Грузчик %s отнес на склад %d предметов с конвейера, решил, что в следующий раз " +
                                    "отнесет %d болванок, и пошел спать.\n", Thread.currentThread().getName(),
                            shippedOnStorageThisTime, countOfBarsToSendToStorage);
                else
                    System.out.printf("Рабочий день заканчивается, Грузчику пришлось проснуться, проверить конвейер и " +
                                    "отнести на склад последние %d болванки.\nГрузчик %s идет досыпать домой!\n",
                            shippedOnStorageThisTime, Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } finally {
                locker.unlock(); // блокировка конвейера снята
            }
        }
    };

    public Runnable stockman = () -> { // это Кладовщик
        Thread.currentThread().setName("Stockman");
        // locker использовался Рабочим и Грузчиком для проверки занятости конвейера, но здесь Кладовщик использует его,
        // чтобы поспать, пока в конце рабочего дня не нужно будет записать wholeTimeToManufacturing
        locker.lock();
        try {
            while (workingDay) {
                condition.await();

                // Но вот во сне Кладовщик замечает поднятый Грузчиком флажок и проверяет, свободен ли доступ на склад:
                if (stockRefilled) {
                    // И если свободен, захватывает общий реурс (склад) в следующем участке кода:
                    semaphore.acquire(); // acquire() throws InterruptedException, но оно уже отловлено здесь
                    // перебирает и проверяет то, что принес Грузчик: болванки оставляет, бутылки - в мусорку:
                    Object temp = new Object(); // (неизвестный пока объект, извлеченный Кладовщиком со склада)
                    int index = 1; // (счетчик бутылок в мусорке)
                    while (!stock.isEmpty()) {
                        temp = stock.peek(); // (перебирает с головы, с первого элемента, принесенного Грузчиком).
                        if (temp.getClass().equals(String.class)) {
                            trashBin.put(index, "бутылка" + (String) temp);
                            stock.remove();
                        }
                    }
                    // Кладовщик проверяет, достаточно ли болванок осталось на складе после чистки того, что принес
                    // Грузчик, и если да, то дает доступ к складу одной из ожидающих машин (какая первой окажется рядом)
                    synchronized (stockMonitor) {
                    if (stock.size() >= 5)
                    System.out.println(stock.peekLast());
                    }
                    // и затем опускает флажок на складе:
                    stockRefilled = false;
                    // и освобождает доступ на склад:
                    semaphore.release();

                }
            }
            System.out.println("wholeTimeToManufacturing = " + wholeTimeToManufacturing);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    };

    public Runnable truck = () -> { // это Грузовики

    };
}
