package atomic.differentKind;

/**
 * Created by WORK on 01.12.2016.
 */
public class VolatileKind {
    static volatile int count; // volatile не делает инкрементацию атомарной
    static volatile boolean workNotDone;


    static Runnable runnable = () -> {
        for (int i = 0; i < 30000; i++) {
            if (Thread.currentThread().isAlive())
                workNotDone = false;
            count++;
        }
        workNotDone = true;
    };

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++)
            new Thread(runnable).start();

//        Thread.sleep(1000); // так тоже можно, без последующей прослушки
        while (!workNotDone) {
            Thread.sleep(500);
        }
        System.out.println(count);
    }
}
