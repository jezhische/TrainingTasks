package methods.overloading;

public class Override {
    private static void a(String s) {
        System.out.println("private void a(String s): " + s);
    }

    public static int a(String s, int i) {
        System.out.println("public static int s(String s): " + s + i);
        return i;
    }

    private void a(int i) {
        System.out.println("private void a(int i): " + i);
    }

    public static void main(String[] args) {
        a("ku");
        a("gu", 5);
        new Override().a(5);
    }

}
