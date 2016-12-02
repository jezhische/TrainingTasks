package threadClass.heap;

/**
 * Created by WORK on 20.09.2016.
 */
public class GarbRunnable implements Runnable {

    int count = 0;
//    int b = 0;
    GarbRunnable(int count) {this.count = count;}
//    Thread[] pool = new Thread[count];
    @Override
    public void run() {
//        System.out.println("поток " + b +  " начал работу");
//        GarbageThread.currentThread().setName(String.valueOf(b));
        System.out.println(Thread.currentThread().getName());
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("поток " + b +  " закончил работу");
    }

    private void cycle() throws InterruptedException {
        this.count = count;

//        for (Thread thread:
//             pool) {
//            new Thread(new GarbRunnable()).start();
//            if (count > 15) {
//                pool[3].sleep(2000);
//            }
//            count++;
//        }
        Thread[] pool = new Thread[count];
        for (int a = 0; a < count; a++) {
            pool[a] = new Thread(new GarbRunnable(count), "thread " + a);
        }
        for (int b = 0; b < count; b++) {

           pool[b].start();
            System.out.println("поток " + b +  " начал работу");
//            GarbageThread.currentThread().setName(String.valueOf(b));
//            System.out.println(Thread.currentThread().getName());
            System.out.println("поток " + b +  " закончил работу");
//            this.b = b;
            if (count > 15) {
                pool[9].sleep(5000);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        GarbRunnable gr = new GarbRunnable(16);
        new Thread(gr).start();

        gr.cycle();

    }
}
