package threadClass.waitNotify.myWaitNotifyManufacturing.multiThreadingGarbage;

/**
 * Created by Ежище on 04.12.2016.
 * http://ru.stackoverflow.com/questions/383768/%D0%A0%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D1%81-reentrantlock
 */
//public class TestMultithreading {
//    static int count = 0; // совместный примитив на 2 потока
//    public static void main(String[] args){
//        Thread t1 = new Thread(new Client());
//        Thread t2 = new Thread(new Client());
//        t1.start();
//        t2.start();
//    }
//}
//class Client implements Runnable {
//    Lock lock = new ReentrantLock();
//
//    @Override
//    public void run() {
//        while (TestMultithreading.count <= 10) {
//            lock.lock();
//            System.out.println(Thread.currentThread().getName() + " " + TestMultithreading.count);
//            TestMultithreading.count++;
//            lock.unlock();
//        }
//    }
//}

import java.util.concurrent.locks.ReentrantLock;

/** Пробую по-другому: */
public class TestMultithreading {
    static int count = 0; // совместный примитив на 2 потока
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        TestMultithreading test = new TestMultithreading();
        Thread t1 = new Thread(new Client(test.lock));
        Thread t2 = new Thread(new Client(test.lock));
        t1.start();
        t2.start();
    }
}

class Client implements Runnable {
    ReentrantLock lock;
    Client(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (TestMultithreading.count <= 10) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " " + TestMultithreading.count);
            ++TestMultithreading.count;
            lock.unlock();
        }
    }
}
