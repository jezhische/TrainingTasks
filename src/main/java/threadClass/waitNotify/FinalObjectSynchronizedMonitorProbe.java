package threadClass.waitNotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ежище on 25.11.2016.
 */
public class FinalObjectSynchronizedMonitorProbe implements Runnable {

    private static final Object object = new Object();
    @Override
    public void run() {
        synchronized (object) {
            System.out.printf("start %s - ", Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("stop %s\n", Thread.currentThread().getName());
        }

    }

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++)
//            new Thread(new FinalObjectSynchronizedMonitorProbe()).start();
        ExecutorService ex = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++)
            ex.execute(new FinalObjectSynchronizedMonitorProbe());
//             ex.submit(new FinalObjectSynchronizedMonitorProbe());
        ex.shutdown();
    }
}
