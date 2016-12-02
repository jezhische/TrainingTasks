package threadClass.SynchronizationDifferentKind;

/**
 * Created by Ежище on 02.12.2016.
 */
public class ClassSynchronization {
    int count;
    volatile boolean workDone;

    Runnable runnable = () -> {
        synchronized (ClassSynchronization.class) { // а вот и ссылка на класс
            workDone = false;
            for (int i = 0; i < 30000; i++) {
                count++;
            }
            workDone = true;
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ClassSynchronization thisSync = new ClassSynchronization();
        for (int i = 0; i < 5; i++)
            new Thread(thisSync.runnable).start();

//        Thread.sleep(1000); // так тоже можно, без последующей прослушки
        while (!thisSync.workDone) {
            Thread.sleep(500);
        }
        System.out.println(thisSync.count);
    }
}
