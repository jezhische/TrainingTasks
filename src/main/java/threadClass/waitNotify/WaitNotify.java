package threadClass.waitNotify;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Ежище on 11.09.2016.
 * http://darkraha.com/rus/java/api/multithread/wait_notify.php
 */
public class WaitNotify {


    // --------------------------------------------------------
    // объект хранения данных, член data является монитором
    // через который общаются поток производителя и поток потребителя
    public static class TaskData {
        private final Deque<String> data = new ArrayDeque<String>();

        public String getData() {

            synchronized (data) {
                try {
                    if (data.size() == 0) {
                        // ожидаем появление данных полторы секунды
                        data.wait(1500);
                    }
                } catch (Exception e) {

                }
                return data.poll();
            }
        }

        public void putData(String s) {
            synchronized (data) {
                data.add(s);
                // уведомляем ожидающий поток о появлении данных для обработки
                data.notify();
            }

            // попробуйте вынести уведомление за блок синхронизации
            // ошибки не будет, но и работать как ожидалось не будет
            // data.notify();
        }
    }

    // --------------------------------------------------------
    // задача производителя - порождает данные, это может занимать
    // вполне заметное время (закачка данных из интернета/разбор текста/тп)
    //
    public static class Producer implements Runnable {
        private final TaskData dest;
        private final int count;

        public Producer(TaskData dest, int count) {
            this.dest = dest;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < count; ++i) {
                    dest.putData("produced - " + i);
                    Thread.sleep(1000); // засыпаем на секунду
                }

            } catch (Exception e) {
            }

            System.out.println("Producer thread finished");
        }
    }

    // --------------------------------------------------------
    // задача потребителя - как только появляются доступные данные, что-то делает с ними
    // потребитель автоматически завершает работу, если 3 раза подряд он не получил данные
    public static class Consumer implements Runnable {
        final int CHECK_TIME = 3;
        final TaskData data;
        int cheking = 0;

        public Consumer(TaskData data) {
            this.data = data;
        }

        @Override
        public void run() {
            String s;
            while (cheking < CHECK_TIME) {
                s = data.getData();
                if (s == null) {
                    ++cheking;
                    System.out.println("Consumer timeout: " + cheking);
                } else {
                    System.out.println("Consumer get item: " + s);
                    cheking=0;
                }
            }
            System.out.println("Cosumer thread finished");
        }

    }


    public static void main(String[] args) {
        int count = 20;
        TaskData data = new TaskData();
        new Thread(new Producer(data, count)).start();
        new Thread(new Consumer(data)).start();
    }

}
