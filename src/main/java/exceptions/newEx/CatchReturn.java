package exceptions.newEx;

public class CatchReturn {
    public static int zeroDivizion(int i) {
        try {
            i = 1 / i;
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(CatchReturn.zeroDivizion(0));
    }
}
