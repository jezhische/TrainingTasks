package threadClass.newT;

public class DeadLockTest {

    private static final Object one = new Object(), two = new Object();

    public static final ThreadGroup GROUP = new ThreadGroup("group");
    public Thread thOne() {
        return new Thread(GROUP, () -> {
        synchronized (one) {
            System.out.printf("Thread %s started and synchronized object one successfully\n",
                    Thread.currentThread().getName());
            Thread.yield(); // без небольшой задержки, когда поток с помощью метода yield() объявляет, что он готов
            // снять блокировку, первый поток может успеть отработать раньше, чем второй запущен, и dead lock
            // не получится
            synchronized (two) {
                System.out.printf("Thread %s synchronized object two successfully\n", Thread.currentThread().getName());
            }
        } // чтобы завершить блокировку объекта one, потоку thOne нужно закончить код в блоке синхронизации, а для этого
        // нужно вначале заблокировать объект two, что он сделать не может, поскольку объект two уже заблокирован
        // потоком thTwo
    }, "thOne");}

    public Thread thTwo() {
        return new Thread(GROUP, () -> {
            synchronized (two) {
                System.out.printf("Thread %s started and synchronized object two successfully\n",
                        Thread.currentThread().getName());
                Thread.yield();
                synchronized (one) {
                    System.out.printf("Thread %s synchronized object one successfully\n", Thread.currentThread().getName());
                }
            }
        }, "thTwo");
    }

    public static void main(String[] args) {
        DeadLockTest deadLock = new DeadLockTest();
        deadLock.thOne().start();
        deadLock.thTwo().start();

        System.out.println(GROUP.activeCount());
        Thread[] threads = new Thread[GROUP.activeCount()];
        int activeThreadsCount = GROUP.enumerate(threads);
        System.out.println(activeThreadsCount);
//        for (Thread thread: threads) {
//            thread.start();
//        }
    }
}
