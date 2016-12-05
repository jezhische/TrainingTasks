package threadClass.waitNotify.myWaitNotifyManufacturing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
 * После отправки машин он должен остановить производство болванок, побудить Грузчика принести на склад последние
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
    private volatile int countOfBarsToSendToStorage = 3,
    /**
     * время, затраченное на производство:
     */
    wholeTimeToManufacturing = 0;
    /**
     * место, в которое Рабочий складывает произведенные болванки и бутылки, и откуда Грузчик их забирает:
     */
    public static ConcurrentLinkedDeque conveyor = new ConcurrentLinkedDeque();
    /**
     * склад с болванками, отделенными от бутылок:
     */
    public LinkedList store = new LinkedList();
    /**
     * специальный мусорный бак для бутылок:
     */
    public Map<Integer, String> trashBin = new HashMap<>();
    /**
     * продолжается или закончено производство
     */
    private static boolean workingDay = true;
    /**
     * блокиратор для работы с конвейером:
     */
    private ReentrantLock locker;
    /**
     * условие для блокиратора:
     */
    private Condition condition;

    public MyWaitNotifyManufacturing() { // при создании объекта класса сразу создаем блокиратор и условие для него:
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public static void main(String[] args) {
        MyWaitNotifyManufacturing manufacturing = new MyWaitNotifyManufacturing();
// ----------------------------------------------------------------------------------------------------
//        Worker worker = manufacturing.new Worker(); // полная форма записи для внутреннего (не-анонимного)
//        //  класса: MyWaitNotifyManufacturing.Worker worker = manufacturing.new Worker();
// ----------------------------------------------------------------------------------------------------
        ExecutorService ex = Executors.newFixedThreadPool(4);
        ex.submit(manufacturing.worker); // для Runnable не знаю, в чем разница между submit и execute
        ex.execute(manufacturing.loader);
        ex.execute(manufacturing.stockman);
        ex.shutdown();
// ----------------------------------------------------------------------------------------------------
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
//        System.out.println("Рабочий посылает на склад:");
//        for (Object bar : conveyor) {
//            if (bar.getClass().equals(Integer.class))
//                System.out.printf("bar %s, ", String.valueOf(bar));
//            else if (bar.getClass().equals(String.class))
//                System.out.printf("BOTTLE%s, ", bar);
//        }
    }

    public Runnable worker = () -> { // это Рабочий

        int currentBarNumber = 1;
        Random randomizer = new Random();
        int timeToSleep = randomizer.nextInt(500);
        boolean bottleInsteadOfBar = randomizer.nextInt(3) == 2;
        Thread.currentThread().setName("Worker");
        System.out.printf("Рабочий %s запущен!\n", Thread.currentThread().getName());
        while (workingDay) {
            try {
                Thread.sleep(timeToSleep); // sleep() is static. Java docs: "Thread.sleep causes the current thread
                // to suspend execution for a specified period." (https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html)
                // so no need to write Thread.currentThread().sleep(...);
                wholeTimeToManufacturing += timeToSleep;
                locker.lock(); // это нечто вроде заменителя блока synchronized, заканчивается на unlock().
                while (conveyor.size() >= countOfBarsToSendToStorage)
                    condition.await(); // работает так же, как wait() - если на конвейере болванок больше определенного
                // количества, доступ к фрагменту кода между condition.await() и locker.unlock() закрыт.
                if (!bottleInsteadOfBar) {
                    Thread.sleep(50);
                    timeToSleep += 50;
                    conveyor.offer(currentBarNumber); // добавление в конец очереди
                    System.out.printf("Рабочий %s спал %dмс, затем проснулся и за 50мс сделал болванку с порядковым" +
                            " номером %d\n", Thread.currentThread().getName(), timeToSleep, currentBarNumber);
                } else {
                    conveyor.offer(String.valueOf(currentBarNumber));
                    System.out.printf("Рабочий %s спал %dмс, затем проснулся и вместо работы подложил на конвейер пустую" +
                                    " бутылку с порядковым номером %s\n", Thread.currentThread().getName(), timeToSleep,
                            String.valueOf(currentBarNumber));
                }
                condition.signalAll(); // сигнал о том, что блокировка с конвейера снята и можно забрать детали, если
                // Грузчику позволяет его собственное условие. Если нет - Рабочий будет класть болванки на конвейер,
                // пока их количество не достигнет countOfBarsToSendToStorage.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } finally { // обязательное условие для разблокировки ресурса в любом случае, поэтому в блоке finally
                locker.unlock();
            }
            currentBarNumber++; // TODO: AtomicInteger... или достаточно volatile? Потоки ведь здесь не конкурируют...
            timeToSleep = randomizer.nextInt(50);
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
        while (workingDay) { // !conveyor.isEmpty() && workingDay
//            int previous = countOfBarsToSendToStorage;
            locker.lock();
            try {
                while (conveyor.size() < countOfBarsToSendToStorage && workingDay) // пока на конвейере нет нужного
                    // количества болванок и рабочий день еще не закончен, грузчик спит.
                    condition.await();
                int shippedOnStorageThisTime = 0; // проверим, сколько болванок отнесет Грузчик - в конце производства
                // на конвейере может остаться меньше болванок, чем он собирался отнести.
                while (!conveyor.isEmpty()) { // просыпаясь, грузчик берет болванки с конвейера в порядке от первой
                    // к последней и относит их на склад.
                    ++shippedOnStorageThisTime;
                    store.offer(conveyor.pop());
                }
                countOfBarsToSendToStorage = randomizer.nextInt(5) + 2; // и выбирает, сколько болванок нести
                // в следующий раз.
                condition.signalAll(); // и сигнализирует, что он освободил конвейер. signalAll() применяется на случай,
                // если больше двух потоков будут использовать лок; если потоков с локом только два, достаточно
                // использовать signal().
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
            locker.lock();
            try {
                while (workingDay) {
                    condition.await();
//                    Thread.sleep(500);
                }
                condition.signalAll();
                System.out.println(wholeTimeToManufacturing);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                locker.unlock();
            }
    };
}
