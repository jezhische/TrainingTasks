package quizfulAndSoOn;

import java.util.Arrays;
import java.util.function.Function;

public class Probe2 {
//    String s = new String("ou") {}; // cannot inherit from final java.lang.String

    interface AA {
        int a();
    }

    static class A implements AA, Function<Object, String> {
        @Override
        public int a() { // public only
            return 0;
        }

        @Override
        public String apply(Object o) { // public only
            return "";
        }

        int ou() {
            return 5;
        }
    }

    public short getB() {
        short b;  //--2--
        b = 0;
        return b;  //--3--
    }

    public static void main(String[] args) {
        int limit = 10;
        int sum = 0;

        int i = 1;
        for (; i <= limit; ) {
            sum += i++;
        }
        System.out.println(sum);

        int j = 1;
        int k = 0;
        k += j++;
        System.out.println(k);
        k += j++;
        System.out.println(k);

        long l = 0;
        String s = new String();
//        s = l.toString(); // это примитив
        Long ll = 0L;
        s = ll.toString(); // так можно
        s = Long.toString(l);
        s = Long.toString(ll); // auto-unboxing
//        s = Long.parse(l); // нет такого метода
//        s = Long.parseLong(l); // только для String
        s = Long.toString(Long.parseLong(ll.toString()));
        System.out.println(s);
        s = Long.toString(Long.parseLong(Long.toString(l)));
        System.out.println(s);
        s = Long.toString(Long.parseLong("" + ll)); // auto ll.toString
        s = Long.toString(Long.parseLong("" + l));

        System.out.println((String) null);
//        System.out.println((char[]) null);
        String su = (String) null;
        Character sup = (Character) null;
        Character[] supp = (Character[]) null;
        Object[] suppp = (Character[]) null;
//        Object[] suppp = (char[]) null; // но не так!
        char[] supppi = (char[]) null;
//        supppi[0] = 'o';
//        System.out.println(supppi[0]);

        String oms = null;
        System.out.println(oms);
        System.out.println(new String());

        char[] hemul = new char[0];
        System.out.println(hemul);
        System.out.println(Arrays.toString(hemul));
        char[] hemulu = {};

        System.out.println(Arrays.toString(hemulu));
        System.out.println(hemulu.length);
        {
//            hemulu[0] = 't'; //ArrayIndexOutOfBoundsException
//            hemulu[1] = 't'; //ArrayIndexOutOfBoundsException
//            hemulu[2] = 't'; //ArrayIndexOutOfBoundsException
            hemulu = new char[5];
            hemulu[0] = 't';
        }
        System.out.println(Arrays.toString(hemulu));
        System.out.println(hemulu.length);

        int r = 0;
        System.out.println(r++);
        System.out.println(++r);
        System.out.println(false == false);

        String x = "Java";
        x.concat(" Rules!");
        System.out.println("x = " + x);
        x.toUpperCase();
        System.out.println("x = " + x);
        x.replace('a', 'X');
        System.out.println("x = " + x);

        String a = "k", b = "k", c = new String("k"), d = new String("k");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c == d);
        System.out.println(a.equals(c));
        System.out.println(c.equals(d));

        System.out.println();
        Ah abs = new Ah();
        abs.setI(4);
        if (abs instanceof Cloneable) {
            Ah abs2 = null;
            try {
                abs2 = (Ah) abs.clone(); // возможно только если в Ah переопределен clone()
                System.out.println(abs.getClass() + " " + abs.getClass().getInterfaces()[0]);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            System.out.println(abs.getI() == abs2.getI()); // true, поскольку в переопаределенном методе обращаемся
            // к супер-методу Object, а не переписываем его


            for(int ii = 0 ; ii < 4 ; ) {
                switch(ii++) {
                    case 1:
                        System.out.print("one ");
                        break;
                    case 3:
                        System.out.print("three ");
                    case 4:
                        System.out.print("four ");
                    default:
                        System.out.print("def ");
                }
            }
        }

        int y = (int)new Integer(5).doubleValue();
        System.out.println("\n" + 6/5);
        System.out.println(6%5);

    }

}

class Ah implements Cloneable {
    private int i;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
