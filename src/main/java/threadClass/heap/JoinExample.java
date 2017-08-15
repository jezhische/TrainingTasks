package threadClass.heap;

/**
 * Created by WORK on 16.11.2016.
 */
public class JoinExample implements Runnable {
    /* Одна нить (поток) может вызвать метод join() у другой нити. В результате первый поток (который вызвал метод)
    приостанавливает свою работу и ждет окончания работы второго потока (у объекта которого был вызван метод join()).
     http://javastudy.ru/interview/concurrent/**/

     static int a = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {}
        System.out.printf("Thread %d started\n", a);
        a++;
    }

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (i < 10) {
            Thread t = new Thread(new JoinExample());
            t.start();
            t.join();
            System.out.println("current Thread name is " + Thread.currentThread().getName());
            System.out.printf("Thread %s stopped\n", t.getName());
            i++;
        }

    }
}
