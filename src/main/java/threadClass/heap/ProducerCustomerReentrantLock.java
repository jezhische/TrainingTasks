package threadClass.heap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ежище on 06.02.2017.
 */
public class ProducerCustomerReentrantLock {
    Stock stock;

    ProducerCustomerReentrantLock() {
        stock = new Stock();
    }

    Runnable producer = () -> {
        System.out.println("producer starts produce");
        for (int i = 0; i < 5; i++)
            stock.put();
    };
    Runnable customer = () -> {
        System.out.println("customer starts getting");
        for (int i = 0; i < 5; i++)
            stock.get();
    };

    public static void main(String[] args) throws InterruptedException {
        ProducerCustomerReentrantLock stockStory = new ProducerCustomerReentrantLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(stockStory.producer);
        executor.submit(stockStory.customer);
        executor.shutdown();
        if (executor.isShutdown()) {
//            Thread.currentThread().join();
            System.out.println("the stockStory is finished");
        }

    }
}

class Stock {
    private ReentrantLock locker;
    private Condition condition;
    private int product = 0;

    Stock() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void put() {
        try {
            locker.lock();
            while (product >= 3) {
                condition.await();
            }
            product++;
            System.out.printf("producer made one product. There are %d products in the stock\n", product);
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public void get() {
        try {
            locker.lock();
            while (product < 1) {
                condition.await();
            }
            product--;
            System.out.printf("customer has taken away one product. There are %d products in the stock\n", product);
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}
