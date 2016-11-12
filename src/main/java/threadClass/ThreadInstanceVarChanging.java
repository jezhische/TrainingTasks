package threadClass;

/**
 * Created by Ежище on 12.11.2016.
 */
public class ThreadInstanceVarChanging implements Runnable {
String test;
    @Override
    public void run() {
        test = "hoho";
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInstanceVarChanging probe = new ThreadInstanceVarChanging(); // а вот если
        // Runnable probe = new ThreadInstanceVarChanging(); - то джава probe.test не видит вооще.
        new Thread(probe).start();
        Thread.currentThread().sleep(500);
        System.out.println(probe.test);
    }
}
