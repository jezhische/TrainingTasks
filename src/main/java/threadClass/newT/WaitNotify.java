package threadClass.newT;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WaitNotify {
    public static final Object obj = new Object();
    private ExecutorService pool;
    private int threadCount, threadNo;

    public WaitNotify(int threadCount) {
        this.threadCount = threadCount;
        pool = Executors.newFixedThreadPool(threadCount);
    }

    public void run() {
        Thread.currentThread().setName("Thread " + threadNo);
        if (threadNo != threadCount - 1) {
            synchronized (obj) { // вызываем блокировку У ОБЪЕКТА obj, а затем вызываем wait() У ОБЪЕКТА obj, в
                // результате поток, которые обратился к методу wait() объекта obj, попадает в wait-set этого объекта,
                // и его выпонение приостанавливается, пока другой поток не вызовет У ОБЪЕКТА obj метод notifyAll(),
                // тогда разблокируются все ожидающие потоки, или notify(), тогда разблокируется один случайный
                // поток из wait-set
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is unlocked after waiting");
            }
        } else synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + ": Releaser is started");
            obj.notifyAll();
        }
    }

    public Set<Future<?>> doIt() {
        Set<Future<?>> set = new HashSet<>();
        for (int i = 0; i < threadCount; i++) {
            threadNo++;
            set.add(pool.submit(this::run));
//            new Thread(this::run).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify(5);
        wn.doIt();
    }
}
