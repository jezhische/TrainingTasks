package varargs;

import java.util.Arrays;

/**
 * Created by Ежище on 24.12.2016.
 */
public class VarargsExample {
    static void printSomething(Object... args) {
        for (Object o : args)
            System.out.println(o);
    }

    static void printSomethingNew(Object... args) {
        System.out.println(Arrays.toString(args));
//        System.out.println(Arrays.deepToString(args));
//        System.out.println(Arrays.asList(args));
    }

    public static void main(String... args) {
        printSomething("pikachu", String.class, "pikabu\n");

        Object[] obj = new Object[3];
        obj[0] = "guru";
        obj[1] = obj;
        printSomething(obj);

        System.out.println();
        obj[2] = 3f;
        printSomethingNew(obj);
    }
}
