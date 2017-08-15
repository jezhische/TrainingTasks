package reference;

/**
 * Created by Ежище on 28.01.2017.
 */
public class VolatileReference {
    // что-то не получаетя сделать проверку для volatile... разницы никакой
    volatile A a = new A();
    Runnable test = () -> {
        Thread.currentThread().setName("test");
        while (true) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName());
                a.i = 125;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    Runnable add13 = () -> {
        Thread.currentThread().setName("add13");
        while (!(a.i == 125)) {
            a.i += 13;
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\"Volatile reference: System exit with a.i = 125. " + Thread.currentThread().getName() +
        " is finished");
//        System.exit(0);
    };

    public static void start() {
        VolatileReference testAttempt = new VolatileReference();
        Thread newAdd5 =  new Thread(testAttempt.add13);
//        newAdd5.setDaemon(true);
        newAdd5.start();

        Thread newTest =  new Thread(testAttempt.test);
        newTest.setDaemon(true);
        newTest.start();
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileReference.start();
        Thread.sleep(800);
        System.out.println(Thread.currentThread().getName() + " is awake");
        Thread.currentThread().join(500); // Здесь как-то все мутно, поскольку currentThread сейчас main, и я
        // требую от моего потока newTest, чтобы он ждал, пока не завершится main, а в реальности выходит все наоборот -
        // main ждет, пока не закончится newTest. Почему?
        // Без указания времени main будет ждать, пока не умрет newTest,
        // а тот Daemon с бесконечным циклом, и умрет, только когда умрет main - взаимная блокировка...
        System.out.println(Thread.currentThread().getName() + " is finished and finish all the Daemon threads");
    }
}

class A {
    public int i = 5;
}
