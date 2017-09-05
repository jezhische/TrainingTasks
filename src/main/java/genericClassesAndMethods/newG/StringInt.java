package genericClassesAndMethods.newG;

import collectionsAndMaps.list.newL.ListIter;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// http://java-s-bubnom.blogspot.com/2015/07/generic.html
// type erasure происходит на этапе компиляции... (информация о generic-ах стирается):
// ничем не ограниченный тип <T> стирается до Object-a,  генерализированный класс A<T> транслируется в обычный класс A.
// Следовательно, конструкция List<String> в скомпилированном коде превратится в обычный List.
// Другими словами информация о generic-ах существует только на этапе компиляции и недоступна в runtime,
// т.е. Определить generic тип во время выполнения невозможно.
public class StringInt {
    public static void main(String[] args) {
        List<Integer> listint = new ArrayList<>(); // создана переменная (поле) List<Integer> listint слева. Справа
// создается объект new ArrayList<>(). ЗНАЧЕНИЕ объекта new ArrayList<>() присваивается ССЫЛКЕ listint типа List<Integer>

//        System.out.println(listint instanceof List<String>); // нельзя: "cannot cast List<Integer> to List<String>"
        System.out.println(listint.getClass()); // "class java.util.ArrayList", а не ArrayList<Integer> - type erasure
        System.out.println(listint instanceof List); // type erasure

//        listint = new ArrayList(); // так тоже можно: создаем объект new ArrayList() и присваиваем его значение
//        // переменной listint, лишая ее обобщенности (генерализации). Теперь listint указывает на НОВЫЙ объект

        List list = listint; // Слева создаем переменную типа List и присваиваем ей значение переменной listint.
        // Теперь есть две переменных: listint типа List<Integer> и list типа List, и обе они указывают на один и тот
        // же объект new ArrayList<Integer>(), который во время компиляции стирается до new ArrayList()

        List<String> liststring = list; // создаем переменную liststring типа List<String> и присваиваем ей значение
        // переменной list. Теперь есть уже 3 переменных, которые указывают на один и тот же объект new ArrayList<>()
        // Но поскольку у liststring тип List<String>, мы запросто можем записать туда String (и только):
        liststring.add("String");
        // А вот в list мы можем записать вообще любой объект, он не генерализован:
        list.add(5);
        list.add(true);
        list.add(new Object());

        System.out.println();
//        listint.forEach((e) -> System.out.print(e + ", ")); // здесь Consumer<? super Integer>,
//        // поэтому получаем ClassCastException: java.lang.String cannot be cast to java.lang.Integer - ПОТОМУ ЧТО
        // Consumer у нас здесь генерализован. А вот через простой foreach - можно:
        for (Object o : listint) {
            System.out.print(o + ", ");
        }
        System.out.println();
        // И вот так можно, поскольку list не генерализован, и Consumer в аргументах forEach() тоже:
        list.forEach((e) -> System.out.print(e + ", "));

        System.out.println();
        // (еще проба итератора):
//        ListIterator<Object> iter = listint.listIterator(); // так нельзя - неприводимые типы
        for (ListIterator iter = listint.listIterator(); iter.hasNext();) {
            System.out.print(iter.next() + ", ");
        }
        System.out.println("\n" + listint.size());
        // todo: NB: listIterator(listint.size()) (иначе начнет с index = 0 и ничего не выведет)
        for (ListIterator iter = listint.listIterator(listint.size()); iter.hasPrevious();) {
            Object obj = iter.previous();
            if (!iter.hasPrevious())
                System.out.println(obj + " ///\\\\\\");
            // NB: если не поставить else, то следующий оператор выполнится независимо от if:
            else System.out.print(obj + "; ");
            iter.remove();
        }
        System.out.println("\n" + listint.size());
    }
}
