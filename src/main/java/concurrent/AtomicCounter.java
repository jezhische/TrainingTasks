package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ежище on 30.11.2016.
 * http://annimon.com/article/1861
 */
public class AtomicCounter {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static int get() {
        return counter.get();
    }

    private static void set(int newValue) {
        counter.set(newValue);
    }

    public static void increment() {
        counter.incrementAndGet();
    }
    Runnable runnable = () -> {
        increment();
//        try {
//            Thread.currentThread().sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            Thread.currentThread().interrupt();
//        }
    }; // та же запись с method reference: Runnable runnable = AtomicCounter::increment;

    public static void main(String[] args) {
        set(0);
//        ExecutorService es = Executors.newFixedThreadPool(100); // подставь сюда newCachedThreadPool()
//        for (int i = 0; i < 100; i++) // или подставь сюда 200
//            es.execute(new AtomicCounter().runnable);
//        System.out.println(get());
//        es.shutdown();
AtomicCounter ac = new AtomicCounter();
        for (int i = 0; i < 1000; i++)
            new Thread(ac.runnable).start();
        System.out.println(get());
    }
}
