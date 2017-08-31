package garbage.logicOperators;

/**
 * Created by WORK_x64 on 31.08.2017.
 */
public class AndAndBoolean {
    private static boolean secondAnd(String message) {
        System.out.println(message);
        return true;
    }
    private static boolean compare(int a, int b) {
        return a < b;
    }

    public static void main(String[] args) {
//        boolean c = compare(5, 8) && secondAnd("happened?");
        System.out.println(compare(5, 8) && secondAnd("happened?"));
        System.out.println(compare(5, 8) || secondAnd("happened?"));
        System.out.println(compare(8, 5) || secondAnd("happened?"));
    }
}
