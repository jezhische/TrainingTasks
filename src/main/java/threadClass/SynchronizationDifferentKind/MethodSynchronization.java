package threadClass.SynchronizationDifferentKind;

/**
 * Created by Ежище on 02.12.2016.
 */
public class MethodSynchronization {
    int count;
    volatile boolean workDone;

    private synchronized void increment() {
        workDone = false;
        for (int i = 0; i < 30000; i++) {
            count++;
        }
        workDone = true;
    }

    Runnable runnable = this::increment; // а здесь вот method reference...

    public static void main(String[] args) throws InterruptedException {
        MethodSynchronization thisSync = new MethodSynchronization();
        for (int i = 0; i < 5; i++)
            new Thread(thisSync.runnable).start();

//        Thread.sleep(1000); // так тоже можно, без последующей прослушки
        while (!thisSync.workDone) {
            Thread.sleep(500);
        }
        System.out.println(thisSync.count);
    }
}
