package threadClass.heap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by WORK_x64 on 09.02.2017.
 */
public class RunnableMethodReference {
    class X {int i = 0;}
    private ReentrantLock locker;
    private Condition condition;
    private X x;
    RunnableMethodReference() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
        x = new X();
        x.i = 1;
    }
    private void count3 () {
//        X x = new X();
//        x.i = 1;
        locker.lock();
        try {
            for (int a = x.i; a < 25; a++) {
                while (x.i % 3 == 0) {
                    condition.await();
                }
                if (x.i == 25) {
                    condition.signalAll();
                    locker.unlock();
                }
                x.i++;
                System.out.printf("t3:%d; ", /*Thread.currentThread().getName(),*/ x.i);
                condition.signalAll();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            locker.unlock();
        }

    }

    private void count4 () {
//        X x = new X();
//        x.i = 1;
        locker.lock();
        try {
            for (int a = x.i; a < 25; a++) {
                while (x.i % 4 == 0) {
                    condition.await();
                }
                if (x.i == 25) {
                    condition.signalAll();
                    locker.unlock();
                }
                x.i++;
                System.out.printf("t4:%d; ", /*Thread.currentThread().getName(),*/ x.i);
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            locker.unlock();
        }

    }

    private void count5 () {
//        X x = new X();
//        x.i = 1;
        locker.lock();
        try {
            for (int a = x.i; a < 25; a++ ) {
                while (x.i % 5 == 0) {
                    condition.await();
                }
                if (x.i == 25) {
                    condition.signalAll();
                    locker.unlock();
                }
                x.i++;
                System.out.printf("t5:%d; ", /*Thread.currentThread().getName(),*/ x.i);
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            locker.unlock();
        }

    }

    private void count (int divider) {
//        X x = new X();
//        x.i = 1;
        locker.lock();
        try {
            for (int a = x.i; a < 25; a++) {
                while (x.i % divider == 0) {
                    condition.await();
                }
                if (x.i == 25) {
                    condition.signalAll();
                    locker.unlock();
                }
                x.i++;
                System.out.printf("t3:%d; ", /*Thread.currentThread().getName(),*/ x.i);
                condition.signalAll();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            locker.unlock();
        }

    }


    /* можно так: **/
//    Runnable t3 = this::count3;
//    Runnable t4 = this::count4;
//    Runnable t5 = this::count5;

    public static void main(String[] args) {
        RunnableMethodReference method = new RunnableMethodReference();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(method::count3);
        executor.execute(method::count4);
        executor.execute(method::count5);
        executor.shutdown();
    }
}
