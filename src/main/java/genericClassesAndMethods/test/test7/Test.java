package genericClassesAndMethods.test.test7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 26.11.2016.
 */
// Wildcard Parameters (wildcards). Этот термин в разных источниках переводится по-разному: метасимвольные аргументы,
// подстановочные символы, групповые символы, шаблоны, маски и т.д. В данной статье я буду использовать "маску"
public class Test {

    static void printList(List<?> list) { // маску можно опустить и написать: static void printList(List list)
        for (Object l : list)
            System.out.println("{" + l + "}");
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        printList(list);
        List<String> strList = new ArrayList<>();
        strList.add("10");
        strList.add("100");
        printList(strList);

        // добавление от меня:
        List smth = new ArrayList<>(); // а вот здесь так написать нельзя: List<?> smth = new ArrayList<>();
        smth.add(20);
        smth.add("200");
        System.out.println(smth);

        // еще примеры:
        List<?> intList = new ArrayList<Integer>();
//        intList.add(new Integer(10)); // не компилируется...
/* intList.add(new Float(10.0f)); даже с закомментированной последней строкой не скомпилируется */
        // но вот это зачем=то возможно:
        List<?> numList1 = new ArrayList<Integer>();
        numList1 = new ArrayList<String>();

        // нехорошо, что переменная numList хранит список со строками. Допустим нам нужно так объявить эту переменную,
        // чтобы она хранила только списки чисел. Решение есть:
        List<? extends Number> numList = new ArrayList<Integer>();
        numList = new ArrayList<Double>(); // это скомпилируется, поскольку Double наследуется от Number
//        numList = new ArrayList<String>(); // а вот это - нет.

        // это были ограниченные маски (Bounded wildcards). Их применение: Допустим нам необходимо посчитать сумму
        // чисел различного типа, которые хранятся в одном списке:
        List<? extends Number> numberList = new ArrayList<>();
//        Integer a = new Integer(5);
//        numberList.add((Number)5); // что-то не удается положить сюда какое-либо число...
        System.out.println(sum(numberList));

        // В завершение этой темы добавлю, что аналогично ключевому слову extends в подобного рода выражениях может
        // использоваться ключевое слово super - "<? super Integer> ". Выражение <? super X> означает, что вы можете
        // использовать любой базовый тип (класс или интерфейс) типа Х, а также и сам тип Х. Пара строк, которые
        // нормально скомпилируются:
        List<? super Integer> intListt = new ArrayList<Integer>();
        System.out.println("The intListt is: " + intListt);



        // а вот сюда все лезет:
        List <? super Number> numListt = new ArrayList<>();
        numListt.add(5);
        numListt.add(5.3);
        numListt.add(5.2f);
        numListt.add(5L);
        System.out.println("The numListt is: " + numListt);
        // Но метод summ не работает...
        System.out.println("The summ(numListt) is: " + summ(numListt));

    }

    public static Double sum(List<? extends Number> numList) {
        Double result = 0.0;
        for (Number num : numList) {
            result += num.doubleValue();
        }
        return result;
    }
// это нечто, что я сочинил сейчас сам, но оно не работает: java.lang.ClassCastException: java.lang.Integer
// cannot be cast to java.lang.Double
//at genericClassesAndMethods.test.test7.Test.summ(Test.java:83)
    public static Double summ(List<? super Number> numList) {
        Double result = 0.0;
        for (Object num : numList) {
            result += (Double)num;
        }
        return result;
    }

}
