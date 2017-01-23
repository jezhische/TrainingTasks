package string;

/**
 * Created by WORK on 23.01.2017.
 */
public class StringPoolProbe {
    public static void main(String[] args) {
        String a = "a", b = "a";
        String c = new String("a");
        String d = new String("a");
        System.out.println("a == b " + (a == b));
        System.out.println("a == c " + (a == c));
        System.out.println("c == d " + (c == d));
        System.out.println("a == c.intern() " + (a == c.intern()));
        System.out.println("a == c " + (a == c));
        System.out.println("c.intern() == d.intern() " + (c.intern() == d.intern()));
        String e = d.intern();
        System.out.println("a == e " + (a == e));

    }
}
