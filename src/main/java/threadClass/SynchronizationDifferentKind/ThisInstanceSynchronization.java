package threadClass.SynchronizationDifferentKind;

/**
 * Created by Ежище on 02.12.2016.
 */
public class ThisInstanceSynchronization {
    int count;
    volatile boolean workDone;

    Runnable runnable = () -> {
        synchronized (this) { // ссылка на текущий объект
            workDone = false;
            for (int i = 0; i < 30000; i++) {
                count++;
            }
            workDone = true;
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ThisInstanceSynchronization thisSync = new ThisInstanceSynchronization();
        for (int i = 0; i < 5; i++)
            new Thread(thisSync.runnable).start();

//        Thread.sleep(1000); // так тоже можно, без последующей прослушки
        while (!thisSync.workDone) {
            Thread.sleep(500);
        }
        System.out.println(thisSync.count);
    }
}
