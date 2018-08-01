package garbage;

public class MultyEqality {
    public static int a;
    public static int a() {
        return a += 1;
    }
    public static void main(String[] args) {
        System.out.println((a() == 1 && a() == 2 && a() == 3));
    }
}
