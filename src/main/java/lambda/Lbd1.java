package lambda;

/**
 * Created by Ежище on 01.10.2016.
 */
public class Lbd1 {
    interface XY {
        public int deal(int x, int y);
    }

    static XY plus = (x, y) -> x + y;

    XY xy = new XY() {
        @Override
        public int deal(int x, int y) {
            return x + y;
        }
    };
    public int summ(int x, int y) {
        return xy.deal(x, y);
    }

    interface DefaultSumm {
        default int newSumm(int a, int b) { return a + b;}
    }
//    DefaultSumm defaultSumm = (a, b) -> a + b; // лямбда с дефолтом не проходит



    public static void main(String[] args) {
        System.out.println(plus.deal(5, 2));
        System.out.println(new Lbd1().summ(5, 2));
    }
}
