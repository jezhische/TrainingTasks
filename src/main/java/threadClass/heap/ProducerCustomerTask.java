package threadClass.heap;

/**
 * Created by WORK_x64 on 06.02.2017.
 */
public class ProducerCustomerTask {
    Store store;
    ProducerCustomerTask() {store = new Store();}
    Thread customer = new Thread(() -> {
       for (int i = 0; i < 5; i++)
           store.get();
    });
    Thread producer = new Thread(() -> {
        for (int i = 0; i < 5; i++)
            store.put();
    });

    public static void main(String[] args) {
        ProducerCustomerTask process = new ProducerCustomerTask();
        process.producer.start();
        process.customer.start();
    }

}
class Store {
    private int product = 0;
    synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product++;
            System.out.println("Производитель доавил 1 товар; товаров на складе " + product);
            notify();
        }
    }
    synchronized int get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product--;
            System.out.println("Покупатель купил 1 товар; на складе осталось " + product);
            notify();
        }
        return 1;
    }
}
