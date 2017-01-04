package javaForTester.generics.generics1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 04.01.2017.
 */
public class ListRawList {
    List rawList1 = new ArrayList();
    List<String> list1 = new ArrayList<>();
    List rawList2 = new ArrayList();
    List<String> list2 = new ArrayList<>();

    {
        rawList1 = list1;
        list2 = rawList2;
    }

    public static void main(String[] args) {
        ListRawList l = new ListRawList();

        l.rawList2.add(5);
        l.rawList2.add("mkm");
        System.out.println(l.list2.get(1));
//        System.out.println(l.list2.get(0)); // а вот тут будет ClassCastException: лежит Integer вместо String.
        // это исключение происходит не при компиляции, а в runtime!

        l.rawList1.add(5);
        l.rawList1.add("mkm");
        System.out.println(l.rawList1.get(0));
        System.out.println(l.list1.get(1));
//        System.out.println(l.list1.get(0)); // снова ClassCastException: лежит Integer вместо String.

    }
}
