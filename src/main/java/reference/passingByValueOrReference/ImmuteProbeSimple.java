package reference.passingByValueOrReference;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Created by Ежище on 20.02.2017.
 */
public class ImmuteProbeSimple {

    static Consumer Strng = (s) -> {s = (String)s + (String)s;};
    static Consumer Intg = (i) -> {i = (Integer)i + (Integer) i;};
    static Consumer Uclass = (u) -> {((U)u).i *= 2;};

    static UnaryOperator SUnary = (s) -> {s = (String)s + (String)s; return s;};


    public static void main(String[] args) {
        String s = "ooo";
        Integer x = 69;
        U u = new U();
        System.out.println(s + " " + x + " " + u.i);
        Strng.accept(s);
        Intg.accept(x);
        Uclass.accept(u);
        System.out.println(s + " " + x + " " + u.i);

        System.out.println(SUnary.apply(s));
        System.out.println(s);
    }
}
class U {
    public int i = 5;
}
