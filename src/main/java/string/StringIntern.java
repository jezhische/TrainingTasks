package string;

/**
 * Created by WORK_x64 on 29.12.2016.
 */
public class StringIntern {
    public static void main(String[] args) {
        String a= "ddd", b;
        char[] c = {'d', 'd', 'd'};
        b = String.valueOf(c);
        System.out.println("a == b : " + (a == b));
        System.out.println("a.equals(b) : " + a.equals(b));

        System.out.println("\na.intern() == b.intern() : " + (a.intern() == b.intern()));

        String d = "ddd";
        System.out.println("\na == d : " + (a == d));

        String aa = String.valueOf(c);
        System.out.println("\naa == b : " + (aa == b));

        String e = "ggg", f = e;
        System.out.println("\ne == f : " + (e == f));
        f = "ggg";
        System.out.println("e == f : " + (e == f));
        f = "hhh";
        f = "ggg";
        System.out.println("e == f : " + (e == f));
    }
}
