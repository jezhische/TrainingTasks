package threadClass.newT.garbage;

public class IncrementInt {
    public static int a;
    public Runnable runnable = () -> {
        for (int i = 0; i < 1000000; i++) {
            a++;
            a--;
        }
        a++;
    };

    public static void main(String[] args) {
        IncrementInt incrementInt = new IncrementInt();
        for (int i = 0; i < 10000; i++) {
            incrementInt.runnable.run();
        }
        System.out.println(a);
    }
}
