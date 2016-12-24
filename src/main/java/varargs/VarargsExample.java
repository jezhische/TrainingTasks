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

    static void multyArgs (int a, boolean boo, String... s) { // только ОДИН varargs, и обязательно В КОНЦЕ
        System.out.println(a + String.valueOf(boo) + Arrays.deepToString(s));
    }

    static void multyArrays (int[]...args) {
        System.out.println(Arrays.asList(args));
        System.out.println(Arrays.deepToString(args));
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

        multyArgs(5, true);
        multyArgs(10, false, "ff", "55");

        int ee[] = {2, 3, 5};
        int uu[] = {99, 0};
        int ii[] = new int[0];
        multyArrays(ee, uu, ii);

        int[][] uuho = {{12, 4}, {14, 8, 9, 32}};
        System.out.println(Arrays.deepToString(uuho));
    }
}
