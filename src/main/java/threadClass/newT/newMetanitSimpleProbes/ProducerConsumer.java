package threadClass.newT.newMetanitSimpleProbes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumer {
    public static void main(String[] args) {
        Store store = new Store(5, 11);
        new Thread(new Producer(store)).start();
        new Thread(new Consumer(store)).start();


    }

}

class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < store.getNeedTo(); i++) {
            store.put();
        }
    }
}

class Consumer implements Runnable {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < store.getNeedTo(); i++) {
            store.get();
        }
    }
}

class Store {
    private Queue storeRoom;
    private int maxCapacity, needTo;
    public static final Object object = new Object();

    public Store(int maxCapacity, int needTo) {
        this.maxCapacity = maxCapacity;
        storeRoom = new ArrayDeque(maxCapacity);
        this.needTo = needTo;
    }

    public int getNeedTo() {
        return needTo;
    }

    // на складе в комнате storeRoom может поместиться только maxCapacity объектов.
    // Потребитель заказывает, а производитель должен произвести needTo объектов.
    // У Store есть метод для получения объектов в комнату и метод для выдачи

    // метод put() - кладем ОДИН объект в комнату при условии, что там есть еще место.
    public synchronized void put() {
        // но если оказалось, что больше не влазит, а цикл "положить" в методе run() в потоке производителя
        // еще не закончен - кидаем поток в режим ожидания (в waitset объекта object)
        while (storeRoom.size() >= maxCapacity) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // если место есть, кладем объект:
            storeRoom.offer(new Object());
            System.out.println("Producer положил один объект на склад, сейчас на объектов на складе " + storeRoom.size());
            // и  объявляем другому потоку, что он может пользоваться складом, если там его условие выполняется
            object.notify();
        }
    }

    public synchronized void get() {
        while (storeRoom.size() < 1) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            storeRoom.poll();
            System.out.println("Consumer забрал один объект со склада, сейчас объектов на складе " + storeRoom.size());
            object.notify();
        }
    }
}
