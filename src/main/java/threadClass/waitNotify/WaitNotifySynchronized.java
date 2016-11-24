package threadClass.waitNotify;

/**
 * Created by Ежище on 23.11.2016.
 * http://initialize.ru/vzaimodeistvie-mejdu-potikami-java/
 */
public class WaitNotifySynchronized {
    private static final Object monitor = new Object();
    private static boolean ready = false;

    public void prepareData() {
        synchronized (monitor) {
            System.out.println("Data prepared");
            ready = true;
            monitor.notifyAll();
        }
    }

    public void sendData() {
        synchronized (monitor) {
            System.out.println("Waiting for data...");
            while (!ready) {
                try {
                    monitor.wait(); // "как только поток достигает метода wait() он перестает быть владельцем монитора,
                    // блокировка снимается, а поток уходит в сон." И, соответственно, prepareData() может осуществиться
                    // (до этого момента синхронизированный монитор не дает произойти тому, что прописано в блоке
                    // синхронизации)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // continue execution and sending data
            System.out.println("Sending data...");
        }
    }

}
