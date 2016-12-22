package heap;

/**
 * Created by Ежище on 22.12.2016.
 * https://habrahabr.ru/post/141080/
 */
public class AssertFactorial {
    int factorial(int n) {
        int result = 1;
        while (n > 1) {
            // Знакомая нам проверка на целочисленное переполнение.
            //
            // При ее срабатывании мы быстро определим, что эта функция должна уметь
            // корректно обрабатывать слишком большие n, ведущие к переполнению.
            //
            // Эта проверка лучше, чем проверка из предыдущего пункта (перед выходом
            // из функции), т.к. она срабатывает перед первым переполнением result,
            // тогда как проверка из предыдущего пункта может пропустить случай, когда
            // в результате переполнения (или серии переполнений) итоговое значение
            // result остается положительным.
            assert(result <= Integer.MAX_VALUE / n) : "the result value higher than the permissible Integer.MAX_Value";
            result *= n;
            --n;
        }
//        if (n == 1)
//            return 1;
//        return n * factorial(n - 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new AssertFactorial().factorial(16));
        System.out.println(new AssertFactorial().factorial(17));

    }
}
