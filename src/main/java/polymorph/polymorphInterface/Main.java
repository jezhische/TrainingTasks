package polymorph.polymorphInterface;

/**
 * Created by Ежище on 18.12.2016.
 */
public class Main {
    public static void polySum(Summable summable) {
        summable.sum();
    }

    public static void main(String[] args) {
        IntSum intSum = new IntSum(5, 10);
        StringSum stringSum = new StringSum("5", "10");
//        Summable intSum = new IntSum(5, 10); // метод polySum сработает, но в Summable нет переменной result
//        Summable stringSum = new StringSum("5", "10");
        polySum(intSum);
        polySum(stringSum);
        System.out.printf("stringSum.result = %s, intSum.result = %d", stringSum.result, intSum.result);
    }
}
