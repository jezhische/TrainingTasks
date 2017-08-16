package garbage.statements;

public class DoubleAnd {

    public int result(int x, int y) {
        boolean b = (x < 5) && ((y = 20) > 10); // правая часть оператора && будет выполнена, только если левая true
        return y;
    }

    public static void main(String[] args) {
        System.out.println(new DoubleAnd().result(7, 15));
        System.out.println(new DoubleAnd().result(4, 15));
    }
}
