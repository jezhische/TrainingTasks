package threadClass.heap;

/**
 * Created by WORK_x64 on 06.02.2017.
 */
public class ProducerCustomerTask {
    Store store;
    ProducerCustomerTask(Store store) {this.store = store;}
    Thread customer = new Thread(() -> {
        System.out.println("customer starts");
       for (int i = 0; i < 5; i++)
           store.get();
    });
    Thread producer = new Thread(() -> {
        System.out.println("producer starts");
        for (int i = 0; i < 5; i++)
            store.put();
    });

    public static void main(String[] args) {
        Store store = new Store();
        ProducerCustomerTask process = new ProducerCustomerTask(store);
        process.producer.start();
        process.customer.start();
    }

}
class Store {
    private int product = 0;
    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар; товаров на складе " + product);
        notify();
    }
    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар; на складе осталось " + product);
        notify();
    }
}
