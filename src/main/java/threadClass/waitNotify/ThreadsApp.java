package threadClass.waitNotify;

/**
 * Created by Ежище on 23.11.2016.
 */
public class ThreadsApp {

    public static void main(String[] args) {

        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
// Класс Магазин, хранящий произведенные товары
class Store{
    private int product=0;
    private boolean available = false;
    public synchronized void get() {
        while (product<1) {
            try {
                wait(); // эта запись означает this.wait(); здесь this - это this.Customer
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
    public synchronized void put() {
        while (product>=3) {
            try {
                wait(); // эта запись означает this.wait(); здесь this - это this.Producer
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}
// класс Производитель
class Producer implements Runnable{

    Store store;
    Producer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put(); // здесь wait() обращается к экземпляру Producer, т.е. к потоку, в котором он запущен
        }
    }
}
// Класс Потребитель
class Consumer implements Runnable{

    Store store;
    Consumer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.get(); // здесь wait() обращается к экземпляру Customer, т.е. к потоку, в котором он запущен
        }
    }
}
