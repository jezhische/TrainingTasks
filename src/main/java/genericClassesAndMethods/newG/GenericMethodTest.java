package genericClassesAndMethods.newG;

public class GenericMethodTest {
    private static <T> T returnType(T t) {
        return t;
    }
    private static <T> void printType(T t) {
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        System.out.println(returnType("").getClass().getSimpleName());
        System.out.println(returnType(0.5).getClass().getSimpleName());

        printType("");
        printType(4);
        printType(4d);
        printType((int)4);

    }
}
