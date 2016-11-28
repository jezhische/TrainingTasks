package genericClassesAndMethods.test.test4;

/**
 * Created by Ежище on 26.11.2016.
 */
// Нет ограничений и на количество переменных с использующих такой тип:
public class PairOfT <T> {
    T object1;
    T object2;

    PairOfT(T one, T two) {
        object1 = one;
        object2 = two;
    }

    public T getFirst() {
        return object1;
    }

    public T getSecond() {
        return object2;
    }
}
