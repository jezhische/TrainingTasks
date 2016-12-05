package threadClass.waitNotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ежище on 25.11.2016.
 */
public class SynchronizedMethodProbe implements Runnable {

    private synchronized void printData() {
        System.out.printf("start %s - ", Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.printf("stop %s\n", Thread.currentThread().getName());
    }

    @Override
    public void run() {
        printData();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            ex.execute(new SynchronizedMethodProbe());
            Thread.currentThread().sleep(150);
        }
        ex.shutdown();

//        for (int i = 0; i < 10; i++) {
//            new Thread(new SynchronizedMethodProbe()).start();
//        Thread.currentThread().sleep(150);
//        }

    }
}
