package threadClass.newT.newMetanitSimpleProbes;

public class NonSynchro {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        for (int i = 0; i < 6; i++) {
            Thread thread = new Thread(new CountThread(commonResource));
            thread.setName("Thread " + i);
            thread.start();
        }
    }

}

class CommonResource {
    int x;
}

class CountThread implements Runnable {
    CommonResource res;

    public CountThread(CommonResource res) {
        this.res = res;
    }

    @Override
    public void run() {
        synchronized (res) {
            res.x = 1;
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " res.x = " + res.x);
                res.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}