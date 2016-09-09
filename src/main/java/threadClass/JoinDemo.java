package threadClass;

/**
 * Created by WORK on 08.09.2016.
 * http://darkraha.com/rus/java/api/multithread/join.php
 */
public class JoinDemo {

    public static class MyRunnable implements Runnable {
        private int count;

        public MyRunnable(int count) {
            this.count = count;
        }

        // задача для потоков: просто засыпаем на 4 мс count раз
        @Override
        public void run() {
            try {
                for (int i = 0; i < count; ++i)
                    Thread.sleep(4);
            } catch (Exception e) {

            }

            System.out.println("thread " + Thread.currentThread().getName()
                    + " finished");
        }
    }


    //--------------------------------------------------------------
    // correct - то что обычно мы ожидаем
    //--------------------------------------------------------------
    // в этом тесте вначале запускаем потоки,
    // а потом в отдельном цикле подсоединяемся к запущенным потокам.
    // В результате ждем завершения всех запущенных потоков,
    // для проверки специально в середину засунул самый длинный поток
    public void test2() {
        int count;
        Thread pool[] = new Thread[10];

        // запускаем потоки:
        try {
            for (int i = 9; i >= 0; --i) {
                count = 100 + 100 * i;
                count = (i == 5) ? count + 800 : count;
                pool[i] = new Thread(new MyRunnable(count), "test2_task" + i
                        + "_" + count);
                pool[i].start();
            }

            // только теперь присоединяемся к запущенным потокам и ждем их завершения
            for (int i = 9; i >= 0; --i) {
                pool[i].join();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("test2 finished");
    }

    //--------------------------------------------------------------
    // "incorrect" - вряд ли вы хотели это
    //--------------------------------------------------------------
    // в этом тесте запускается поток и сразу присоединяемся к нему
    // в результате ждем завершение одного запущенного потока, и только потом запускаем следующий
    public void test1() {
        int count;
        Thread t;

        try {
            for (int i = 9; i >= 0; --i) {
                count = 100 + 100 * i;
                t = new Thread(new MyRunnable(count), "test1_task" + count);
                t.start();
//                t.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("test1 finished");
    }

    public static void main(String[] args) {
        JoinDemo jd =new JoinDemo();
        jd.test2();
        jd.test1();
    }
}
