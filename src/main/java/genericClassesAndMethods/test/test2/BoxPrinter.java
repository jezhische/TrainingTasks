package genericClassesAndMethods.test.test2;

/**
 * Created by Ежище on 26.11.2016.
 */
public class BoxPrinter <T> { // T называется "имя типа"
    private T val; // вместо private Object val; - т.е. тип объекта не определен, зависит от того, каким типом будет
    // параметризован образец

    public BoxPrinter(T arg) { // а не (Object arg)
        val = arg;
    }

    public String toString() {
        return "{" + val + "}";
    }

    public T getValue() { // а не public Object getValue()
        return val;
    }
}

class Test {
    public static void main(String[] args) {
        BoxPrinter<Integer> value1 = new BoxPrinter<Integer>(new Integer(10));
        System.out.println(value1);
        Integer intValue1 = value1.getValue();
        BoxPrinter<String> value2 = new BoxPrinter<String>("Hello world");
        System.out.println(value2);

        // Здесь повторяется ошибка предыдущего фрагмента кода
        // Но компилятор обнаруживает ошибку:
//        Integer intValue2 = value2.getValue();

        // А  вот так уже все нормально:
        String stringValue = value2.getValue();
    }
}
