package static__;

/**
 * Created by Ежище on 29.11.2016.
 */
public class StaticProbe {
    StaticProbe() {};
    StaticProbe(int c, int d) {
        this.c = c;
        this.d = d;
        c = 25;}

    public static int sum(int a, int b) {return a + b;}
    static int c, d;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "++c + d = " + (++c + d));
        }
    };

    public static void main(String[] args) {
        System.out.println("StaticProbe.sum(5, 6) = " + StaticProbe.sum(5, 6));
        StaticProbe.c = 7;
        StaticProbe sp = new StaticProbe();
        sp.d = 9;
        StaticProbe sp2 = new StaticProbe();
        System.out.println("StaticProbe.sum(c, d) = " + StaticProbe.sum(c, d));
        for (int i = 0; i < 4; i++) {
            new Thread(sp.runnable).start();
        }
        System.out.println("sp2.sum(c, d) = " + sp2.sum(c, d));


    }
}
