package primitive;

public class RandomDoubleToInt {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println((int) Math.round (Math.random() * 10));
        }
    }
}
