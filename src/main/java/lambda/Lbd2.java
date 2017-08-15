package lambda;

/**
 * Created by Ежище on 06.02.2017.
 */
public class Lbd2 {
    public interface Operationable {
        void calc (double x, double y);
    }
    public static Operationable summ = (x, y) -> {
        System.out.printf("%.5f + %.5f = %.5f\n", x, y, (x + y));
        };
    public static Operationable div = (x, y) -> {
        System.out.printf("%.5f / %.5f = %.5f\n", x, y, (x / y));
        };
    public static Operationable mult = (x, y) -> {
        System.out.printf("%.5f * %.5f = %.5f\n", x, y, (x * y));
        };
    public static Operationable diff = (x, y) -> {
        System.out.printf("%.5f - %.5f = %.5f\n", x, y, (x - y));
        };

    public static void main(String[] args) {
        diff.calc(5, 0.5);
        div.calc(21.368, 18);
    }
}
