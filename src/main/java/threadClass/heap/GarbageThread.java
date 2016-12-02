package threadClass.heap;

/**
 * Created by WORK on 20.09.2016.
 */
public class GarbageThread extends Thread {

    public void run() {
        System.out.println("поток начал работу");
        GarbageThread.currentThread().setName("kuku");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("поток закончил работу");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        GarbageThread garb = new GarbageThread();
        garb.start();

    }

}
