package javaFromTkach.generics.generics1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by WORK_x64 on 04.01.2017.
 */
public class ListEListInt <T> {
    public <E> void test (Collection<E> collection) { // а вот так бы сработало: public <E> void test (List<E> collection)
        for (E e : collection)
            System.out.println(e);
        System.out.println("<E> test was running");
    }
    public void test (List<Integer> listInteger) { // или если бы не было этого перегруженного метода - тоже бы сработало
        for (Integer integer : listInteger)
            System.out.println(integer);
        System.out.println("<Integer> test was running");
    }
// ????? На самом деле (?????), если мы создаем образец класса как "сырой" тип, то получаем
    // test (Collection<E> collection) и (List<Integer> listInteger) (возможно, неопределенные дженерики все-таки
// стираются, и тут test (Collection collection)). При выборе между перегруженными методами выбирается тот, где в
// аргументе коллекция с ОБЪЕКТАМИ НУЖНОГО ТИПА, но поскольку такой нет - выбирается наиболее близкий тип коллекции,
// т.е. List.
// А вот если
    public static void main(String[] args) {
        ListEListInt le = new ListEListInt(); // как только мы создали образец класса как сырой тип, компилятор
        // сразу стирает всю инфоормацию о дженериках, но предварительно приводит принудительно те дженерики, которые
        // указаны ясно, к их типам - т.е. List становится List<Integer> (?????)

        List <String> list = Arrays.asList("dd", "gg", "bb");
//        le.test(list); // т.е. вот это - не сработает, запустится <Integer> test, поскольку образец класса
// не типизирован, и компилятор думает, что мы вызываем test (Collection collection) и test (List listInteger)

        ListEListInt <String> leStr = new ListEListInt<>();
        leStr.test(list); // а вот это - сработает, поскольку указан тип в классе ListEListInt <String>

        ListEListInt <?> query = new ListEListInt<>();
        query.test(list); // блин, и почему? Получается, как только образец класса типизирован, все дженерики сразу
        // стали работать?
    }

}
