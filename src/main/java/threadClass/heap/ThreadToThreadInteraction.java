package threadClass.heap;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ежище on 02.12.2016.
 */
public class ThreadToThreadInteraction {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        DataProvider dataProvider = new DataProvider();
        DataConsumer dataConsumer = new DataConsumer(dataProvider);
        executor.execute(dataProvider);
        executor.execute(dataConsumer);
        Thread.sleep(10000);
        executor.shutdownNow();
    }


}


class DataProvider implements Runnable {

    private String userId;

    public synchronized String getLogin() {
        return userId;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            userId = UUID.randomUUID().toString();
        }
    }
}


class DataConsumer implements Runnable {
    private DataProvider dataProvider;

    public DataConsumer(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                return;
            }
            System.out.println(dataProvider.getLogin());
        }
    }
}
