package threadClass.newT;

public class ThreadTestNonSynch implements Runnable {

    private static ThreadTestNonSynch
            shared = new ThreadTestNonSynch();
    public /*synchronized*/ void process() {
        for (int i=0; i<3; i++) {
            System.out.println(
                    Thread.currentThread().
                            getName()+" "+i);
            Thread.yield();
        }
    }

    public void run() {
//        shared.process(); // non-synchronized
        synchronized (shared) {shared.process();}
    }
    public static void main(String s[]) {
        for (int i=0; i<3; i++) {
            new Thread(new ThreadTestNonSynch(),
                    "Thread-"+i).start();
        }
    }
}
