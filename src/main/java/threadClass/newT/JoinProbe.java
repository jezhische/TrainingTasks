package threadClass.newT;

public class JoinProbe {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("Thread started: " + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished: " + Thread.currentThread().getName());
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        //start second thread after waiting for 2 seconds or if t1 is dead
        t1.join(2000);
        t2.start();
        //start third thread only when first thread is dead
        t1.join();
        t3.start();
        //let all threads finish execution BEFORE finishing main thread, or main will be finished earlier and println()
        // won't executed
        t1.join();
        t2.join();
        t3.join();
        System.out.println("All threads are dead, exiting main thread");
    }
}
