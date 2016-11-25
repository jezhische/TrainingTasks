package threadClass.waitNotify;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Ежище on 23.11.2016.
 * Задача: Рабочий спит неопределенное время (не более 3000мс), затем производит болванку за 50мс и засыпает снова.
 * Когда он произвел 3 болванки, просыпается Грузчик и относит их на склад, но в это время Рабочий не прекращает
 * работать (или спать). Грузчик снова идет спать, перед этим решив, сколько болванок он отнесет в следующий раз
 * (больше 2, но меньше 6). У него чуйка, он просыпается, когда болванок ровно столько, сколько он задумал. Иногда
 * (примерно в трети случаев, но без закономерности) рабочий хитрит и подкладывает пустую бутылку вместо болванки.
 * Грузчику все равно, что он несет, он неграмотный. А вот Кладовщик должен отделить зерна от плевел, выкинуть бутылки
 * и отправить 4 машины по 5 болванок в каждой, полупустые машины отправлять нельзя. После отправки машин он должен
 * записать, сколько всего времени было потрачено на производство и сколько болванок осталось на складе,
 * и отправить рабочего с грузчиком спать домой навсегда (производство закончено).
 * Можно в консоли или попробовать в окне.
 * PS "не прекращает работать" - это похоже на использование volatile или java.util.concurrent, или просто synchronized.
 */
public class MyWaitNotifyManufacturing {
    private int countOfBarsToSendToStorage = 0; // , barsProducedByWorker;
    LinkedList barsProducedByWorker = new LinkedList();
    LinkedList store = new LinkedList();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            new Thread(new Worker()).start();
    }

    public static class Randomizer {
        Random rand = new Random();
        //            rand.setSeed(System.currentTimeMillis());
        int timeToSleep = rand.nextInt(3000);
    }

    public static class Worker implements Runnable {
//        public static Worker worker = new Worker();

        @Override
        public void run() {
//            Random rand = new Random();
////            rand.setSeed(System.currentTimeMillis());
//            int timeToSleep = rand.nextInt(3000);
//            int timeToSleep = (int) (Math.random() * 3000);
            Randomizer randomizer = new Randomizer();
            int timeToSleep = randomizer.timeToSleep;
            synchronized () {
                try {
                    Thread.sleep(timeToSleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("я проснулся через %d миллисекунд\n", timeToSleep);
            }

        }
    }

    public static class Loader {
    }                // грузчик

    public static class Stockman {
    }          // кладовщик
}
