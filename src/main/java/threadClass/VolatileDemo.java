package threadClass;

/**
 * Created by WORK on 14.09.2016.
 * http://darkraha.com/rus/java/api/multithread/volatile.php
 */
public class VolatileDemo {
    // вначале попробуйте без volatile
    volatile private boolean btExit = false;
    volatile private boolean isRunning = true;

    // задача для интерфейсного потока
    Runnable gui = new Runnable() {

        @Override
        public void run() {
            int k=-1;
            while (isRunning) {
                try {
                    k = System.in.read() ;
                    btExit = k>=0;
                    System.out.println("gui input: "+k);
                } catch (Exception e) {
                }
            }
            System.out.println("gui thread finished");
        }

    };

    // задача для игрового потока
    Runnable game = new Runnable() {

        @Override
        public void run() {
            int k=1;
            while (!btExit) {
                k+=k;
                k%=100;
                // System.out.print("");
            }
            isRunning=false;
            System.out.println("game thread finished"+k);
        }
    };

    // запуск потоков
    public void start() {
        new Thread(gui).start();
        new Thread(game).start();
    }


    // чтобы остановить программу запущенную без volatile и без System.out.print(""); в игровом цикле
    // в Eclipse в окне консоли кликните на красный квадрат
    public static void main(String[] args) {
        new VolatileDemo().start();
    }

}
