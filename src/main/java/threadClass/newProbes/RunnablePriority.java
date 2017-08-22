package threadClass.newProbes;

/**
 * Created by Ежище on 21.08.2017.
 */
public class RunnablePriority implements Runnable {
    @Override
    public void run() {
        double calc;

        for (int i = 0; i < 500000; i++) {
            calc = Math.sin(i * i);
            if (i % 100000 == 0)
                System.out.println(getName() + " count: " + i / 100000 + ", calc = " + calc);
        }
    }

    private String getName() {
        return Thread.currentThread().getName();
    }

    public Thread[] createThreads(int requiredNumber) {
        Thread[] threads = new Thread[requiredNumber];
        for (int i = 0; i < requiredNumber; i++) threads[i] = new Thread(this, "Thread " + i);
        return threads;
    }

    public Thread[] addPriority(Thread[] unordered) {
        for (int i = 0; i < unordered.length; i++) {
            unordered[i].setPriority(Thread.MIN_PRIORITY + (Thread.MAX_PRIORITY - Thread.MIN_PRIORITY) / (i + 1));
        }
        return unordered;
    }

    public void startThreadPool(Thread[] toStart) {
        for (int i = 0; i < toStart.length; i++) {
            toStart[i].start();
            System.out.println(toStart[i].getName() + " started");
        }
    }

    public static void main(String[] args) {

        RunnablePriority test = new RunnablePriority();
        Thread[] threads = test.createThreads(3);
        test.addPriority(threads);
        test.startThreadPool(threads);
    }
}
