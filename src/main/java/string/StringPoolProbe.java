package string;

import java.math.BigDecimal;

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
        /* дальше пробы конкатенации **/
        String f  = "ku";
        System.out.println("f = " + f);
        String g = "".concat("");
        System.out.println("g = " + g);
        f += "ku";
        System.out.println("f = " + f);
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("ko").append(f);
        f = sbuilder.toString();
        System.out.println("f = " + f);
        String i = "qwerty";
        System.out.println(i + " " + new StringBuilder(i).reverse().toString());



    }
}
