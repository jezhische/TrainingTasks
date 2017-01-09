package collectionsAndMaps.list.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Ежище on 17.12.2016.
 */
public class ArrayListShiftElements {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            list.add(i, i);
        System.out.println(list);
        list.add(3, 25);
        System.out.println(list);

        List<Integer> list2 = Arrays.asList(23, 15);
        List<String> stringList = Arrays.asList("lk", "jnhkj");
        System.out.println(list.addAll(list2));
//        System.out.println(list.addAll(stringList)); // компилятор выдает ошибку сразу
        System.out.println(list);

        for (ListIterator<Integer> li = list.listIterator(); li.hasNext();)
            System.out.print(li.next() + ", ");
        for (ListIterator<Integer> li = list.listIterator(); li.hasPrevious();)
            System.out.print(li.previous() + ", ");
    }
}
