package threadClass.heap;

/**
 * Created by Ежище on 03.09.2016.
 */
//public class MultyThread1 {
//}
public class MultyThread1 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MyThread2(), String.format("Thread %d", i));
        }
        startThreads(threads);
    }

    private static void startThreads(Thread[] threads) {
        for (Thread t : threads)
            t.start();
    }
}

class MyThread2 implements Runnable {
    public void run() {
        for(int i = 0; i < 1_000_000_00; i++) {
            if(i % 1_000_000_00 == 0) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

}