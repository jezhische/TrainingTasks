package garbage.increment;

public class IncrementProbe {
    private int a = 0;

    private void printA() {
        System.out.println(a++);
    }

    public void test() {
        printA();
    }

    private static int b;
    public int incrementB() {return b++;}

    public static void main(String[] args) {
        IncrementProbe inc = new IncrementProbe();
        inc.test();
        inc.test();
        inc.test();
        System.out.println(inc.incrementB());
        System.out.println(inc.incrementB());
        System.out.println(inc.incrementB());
    }
}
