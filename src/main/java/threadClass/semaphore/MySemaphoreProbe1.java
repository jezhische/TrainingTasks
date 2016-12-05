package threadClass.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ежище on 04.12.2016.
 */
public class MySemaphoreProbe1 {
//    volatile private int commonResource = 0;
    private String name;
    private Semaphore semaphore;

    private MySemaphoreProbe1() {
        semaphore = new Semaphore(1);
        name = "Thread "; //name = "Thread " + String.valueOf(suff);
    }
// ------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        MySemaphoreProbe1 msp = new MySemaphoreProbe1();
        NewCommonResource com = new NewCommonResource(0);
        for (int i = 0; i < 4; i++) {
            new Thread(new ThreadApp(msp.semaphore, msp.name, com.newCommonResource, i)).start();
        }
    }
}
// ------------------------------------------------------------------------------------
class NewCommonResource {
    NewCommonResource(int newValue) {
        newCommonResource = new AtomicInteger(newValue);
    }
    AtomicInteger newCommonResource;
}
// ------------------------------------------------------------------------------------
class ThreadApp implements Runnable {
    private Semaphore semaphore;
    private String name;
    private AtomicInteger commonResource;
    private int suffix;

    ThreadApp(Semaphore semaphore, String name, AtomicInteger commonResource, int suffix) {
        this.semaphore = semaphore;
        this.name = String.valueOf(suffix);
        this.commonResource = commonResource;
        this.suffix = suffix;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name + String.valueOf(suffix));
        System.out.printf("Thread %s is waiting for permits to acquire commonResource.\n", name);
        try {
            semaphore.acquire();
            System.out.printf("Thread %s acquires commonResource.\n", name);
            for (int i = 0; i < 3; i++) {
                commonResource.incrementAndGet();
                System.out.printf("Thread %s increments commonResource to %d\n", name,
                        commonResource.get());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } finally { // release() можно не помещать в блок finally (по всей видимости), поскольку прерывание потока по-
            // любому освободит блокировку
            System.out.printf("Thread %s releases commonResource.\n", name);
            semaphore.release();
        }
    }
}
