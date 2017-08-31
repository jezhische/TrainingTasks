package threadClass.newT;

public class DaemonGroup implements Runnable {
    public final static ThreadGroup GROUP = new ThreadGroup("Daemon demo");
    private int start;

    public DaemonGroup(int s) {
        start = (s % 2) == 0 ? s : s + 1;
        new Thread(GROUP, this, "Thread" + start).start();
    }

    @Override
    public void run() {
        for (int i = start; --i > 0; ) {
//            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (start > 2 && i == start / 2)
                new DaemonGroup(i);
        }
    }

    public static void main(String[] args) {
        new DaemonGroup(16);
        new DaemonDemo();
    }
}

class DaemonDemo extends Thread {

    public DaemonDemo() {
        super("Daemon demo thread");
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        Thread[] threads = new Thread[10];
        while (true) {
            int count = DaemonGroup.GROUP.activeCount();
            if (count > threads.length) threads = new Thread[count + 10];
            count = DaemonGroup.GROUP.enumerate(threads);
            for (int i = 0; i < count /*&& threads[i] != null*/; i++) System.out.print(threads[i].getName() + ", ");
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Thread.yield();
        }
    }
}
