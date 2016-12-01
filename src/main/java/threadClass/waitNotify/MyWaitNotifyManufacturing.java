package threadClass.waitNotify;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ежище on 23.11.2016.
 * Задача: Рабочий спит неопределенное время (не более 500мс), затем производит болванку за 50мс, подписывает ее
 * числом - порядковым номером, и засыпает снова. Иногда (примерно в трети случаев, но без закономерности) ему лень
 * становиться за станок, он хитрит и подкладывает вместо болванки пустую бутылку, которая похожа по форме, но сделана
 * из стекла, а не металла (объект или примитивная переменная другого типа). Бутылку он также нумерует по порядку,
 * но времени на "производство" не тратит.
 * <p>
 * Когда он произвел 3 болванки, просыпается Грузчик и относит их на склад, но в это время Рабочий не прекращает
 * работать (или спать). Грузчик снова идет спать, перед этим решив, сколько болванок он отнесет в следующий раз
 * (больше 2, но меньше 6). У него чуйка, он просыпается, когда болванок ровно столько, сколько он задумал.
 * <p>
 * Грузчику все равно, что он несет, он неграмотный. А вот Кладовщик должен отделить зерна от плевел, выкинуть бутылки
 * в специальный мусорный бак и отправить 4 машины по 5 болванок в каждой, полупустые машины отправлять нельзя.
 * После отправки машин он должен записать, сколько всего времени было потрачено на производство, сколько болванок
 * осталось на складе, сколько бутылок было подложено, и отправить рабочего с грузчиком спать домой совсем
 * (производство закончено).
 * Можно в консоли или попробовать в окне.
 * PS "не прекращает работать" - это похоже на использование для счетчика порядкового номера и для добавления в
 * хранилище java.util.concurrent, или просто synchronized (увы, volatile для инкремента и для коллекции не прокатит).
 */
public class MyWaitNotifyManufacturing {
    /**
     * сколько болванок Грузчик решает отправить на склад в этот раз (первоначально 3):
     */
    private int countOfBarsToSendToStorage = 3,
    /**
     * время, затраченное на производство:
     */
    wholeTimeToManufacturing = 0;
    /**
     * место, в которое Рабочий складывает произведенные болванки и бутылки, и откуда Грузчик их забирает:
     */
    public static LinkedList barsProducedByWorker = new LinkedList();
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


    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            ex.execute(new Worker());
        }
        ex.shutdown();
    }


    public static class Worker implements Runnable {
        //        static final Object monitor = new Object();
        private Random randomizer = new Random();
        private int timeToSleep = randomizer.nextInt(500);
        private boolean bottleInsteadOfBar = randomizer.nextInt(3) == 2;
        // -------------------------------------------------------------------
//        private static volatile int barNumber = 1;
// -------------------------------------------------------------------
//        private static synchronized void incrementBarNumber (int barNumber) {
//            Worker.barNumber = barNumber;
//            ++barNumber;
//        }
//        public static synchronized int getBarNumber() { return barNumber; }
// ---------------------------------------------------------------------------
        private static final AtomicInteger barNumber = new AtomicInteger(0);
// ---------------------------------------------------------------------------
//        private static final AtomicReferenceFieldUpdater<Integer,barNumber> updater =
//                AtomicReferenceFieldUpdater.newUpdater(Integer.class, Book.class, "whatImReading");


        @Override
        public void run() {
//            barNumber.incrementAndGet();
//            synchronized (monitor) {
            int i = 0;
            while (workingDay) {
                try {
                    i++;
                    Thread.sleep(timeToSleep);
                    int currentBarNumber = barNumber.incrementAndGet();
                    if (!bottleInsteadOfBar)
                        barsProducedByWorker.addLast(currentBarNumber);
                    else
                        barsProducedByWorker.addLast(String.valueOf(currentBarNumber));
                    System.out.println(barsProducedByWorker);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("поток %s: %dмс\n", Thread.currentThread().getName(), timeToSleep);
                if (i == 21)
                    workingDay = false;
//            }
            }
        }
    }

    public static class Loader {
    }                // грузчик

    public static class Stockman {
    }          // кладовщик
}
