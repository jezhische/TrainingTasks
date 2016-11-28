package genericClassesAndMethods.test.test6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 26.11.2016.
 */
public class Utilities {
    // начинается описание дженерик-методов
    public static <T> void fill(List<T> list, T val) { // NB: здесь метод типа void, ничего не возвращает, но до
        // обозначения возвращаемого типа void указан параметр метода.
        for (int i = 0; i < list.size(); i++)
            list.set(i, val);
    }
}

class Test {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        System.out.println("Список до обработки дженерик-методом: " + intList);
        Utilities.fill(intList, 0);
        System.out.println("Список после обработки дженерик-методом: "
                + intList);
    }
}

class Question {
//    List<Integer> list = new List<Integer>(); // не компилируется: List - это интерфейс
    List<Integer> list = new ArrayList<Integer>();
//    List<Number> list = new ArrayList<Integer>(); // не компилируется: дженерик-типы д.б. одинаковыми, и связи
// наследования здесь не имеют значения.
//    List<Integer> list = new ArrayList<Number>(); // то же самое.

    List<?> intList = new ArrayList<Integer>(); // указание в качестве параметра маски (подстановочного символа,
    // шаблона) - компиляция проходит, см. пакет test7
}
