package threadClass.heap;

/**
 * Created by WORK_x64 on 13.02.2017.
 */
public class MainInterrupt {
    public void go() {
        System.out.printf("Thread %s is running\n", Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread %s is finished\n", Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        System.out.printf("Thread %s is running\n", Thread.currentThread().getName());
        Thread dreamer = new Thread(new MainInterrupt()::go, "dreamer");
        dreamer.setDaemon(true);
        dreamer.start();
        System.out.printf("Thread %s is finished\n", Thread.currentThread().getName());
//        Thread.currentThread().interrupt();
//        System.out.println(Thread.currentThread().isAlive());
    }
}
