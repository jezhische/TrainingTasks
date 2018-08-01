package threadClass.newT.threadToThread;

import java.util.UUID;

public class DataProvider implements Runnable {
     private String userId;

//  NB: synchronized. Т.е., если другой поток запросит userId, ни этот, ни еще какой-нибудь потоки не смогут в это время
// получить доступ к этой переменной?
    public synchronized String getUserId() {
        return userId;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
            // immutable universally unique identifier:
            userId = UUID.randomUUID().toString();
        }
    }
}
