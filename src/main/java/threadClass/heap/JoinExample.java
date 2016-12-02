package threadClass.heap;

/**
 * Created by WORK on 16.11.2016.
 */
public class JoinExample implements Runnable {

     static int a = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {}
        System.out.printf("Thread %d started\n", a);
        a++;
    }

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (i < 10) {
            Thread t = new Thread(new JoinExample());
            t.start();
            t.join();
            System.out.println("current Thread name is " + Thread.currentThread().getName());
            System.out.printf("Thread %s stopped\n", t.getName());
            i++;
        }

    }
}
