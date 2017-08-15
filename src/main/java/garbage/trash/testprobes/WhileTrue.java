package garbage.trash.testprobes;

/**
 * Created by WORK_x64 on 13.01.2017.
 */
public class WhileTrue {
    static int i;

    static int iii(int i) {
        try {
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }

    int aaa (int d) {
        if (d > 0)
            return d;
        else
            return 0;
    }

    public double sqr(double arg) {
        int k = 1;
        return k;
    }
    public static double sqr4(double arg) {
        while (true);
    }

    public static double sqr2(double arg) {
        throw new RuntimeException();
    }

    public static double sqr3(double arg) throws Exception {
//        System.exit(1);
//        Runtime.getRuntime().exit(1);
//        throw new NoSuchElementException();
        throw new Exception();
    }

    public static void main(String[] args) {
//        int v1=1; long v2=2;
        int v1=1; long v2=2; v1+=v2;
//        v1=v1+v2;
        v2=v1+v2;
        v2+=v1;
        v1 = v1 + (int)v2;
        long v3 = (long) v1;


        WhileTrue wt = new WhileTrue();
        boolean b = true;
        i = 10;
//        while(true)
//        {
//            i += 1000000;
//            System.out.println(i);
//        if (i > 100000)
//            break;
//        }

//        System.out.println(sqr3(0.5));


    }

}
