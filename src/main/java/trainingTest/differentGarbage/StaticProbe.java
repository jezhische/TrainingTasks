package trainingTest.differentGarbage;

/**
 * Created by Ежище on 06.08.2016.
 */
public class StaticProbe {
    static int a = 5;
    void hg(){a+=2;}
    void jk(){a+=6;}
    static void op(){a+=3;}

    public static void main(String[] args) {
        StaticProbe r = new StaticProbe();
        System.out.println(a);
        r.hg();
        System.out.println(a);
        StaticProbe u = new StaticProbe();
        u.jk();
        System.out.println(a);
        op();
        System.out.println(a);
        op();
        System.out.println(a);
        r.hg();
        System.out.println(a);
        StaticProbe.InnerStat.pr();
        System.out.println(a);
        StaticProbe w = new StaticProbe();
        w.lk();
        System.out.println("lk+=12 = " + a);


    }

    void lk() {
        InnerStat.pr();
        a+=10;
    }
    static class InnerStat {
        static void pr() {
            StaticProbe o = new StaticProbe();
            o.hg();

        }


    }
}
