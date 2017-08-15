package genericClassesAndMethods.test.test3;

/**
 * Created by Ежище on 26.11.2016.
 */
// При создании дженерик-классов мы не ограничены одним лишь типом (Т) – их может быть несколько:
public class Pair <T1, T2> {
    T1 object1;
    T2 object2;

    Pair(T1 one, T2 two) {
        object1 = one;
        object2 = two;
    }

    public T1 getFirst() {
        return object1;
    }

    public T2 getSecond() {
        return object2;
    }
}

class Test {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<Integer, String>(6,
                " Apr");
        System.out.println(pair.getFirst() + pair.getSecond());
    }
}
