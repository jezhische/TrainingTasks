package threadClass.SynchronizationDifferentKind;

/**
 * Created by WORK on 01.12.2016.
 */
public class ObjectSynchronization {
//    static volatile int count; // volatile не делает инкрементацию атомарной
    static volatile boolean workDone;
    static Integer count = 0;
    static final Object object = new Object(); // а вот synchronized делает



    static Runnable runnable = () -> {
//        if (Thread.currentThread().isAlive())
//            workDone = false;
        synchronized (object) {
            workDone = false;
            for (int i = 0; i < 30000; i++) {
//                if (Thread.currentThread().isAlive())
//                    workDone = false;
                count++;
            }
            workDone = true;
        }

    };

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++)
            new Thread(runnable).start();

//        Thread.sleep(1000); // так тоже можно, без последующей прослушки
        while (!workDone) {
            Thread.sleep(500);
        }
        System.out.println(count);
    }
}
