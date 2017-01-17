package collectionsAndMaps.garbage;

import java.util.*;

/**
 * Created by WORK_x64 on 17.01.2017.
 */
public class MethodListProbe {
    public static Collection<?> method (Collection<?> list) {
        return list;
    }

    public static void main(String[] args) {
        Collection<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list1.add(i);
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            list2.offer(i);
        Collection<Integer> list3 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++)
//            list3.offer(i);
            ((ArrayDeque)list3).offer(i);
        Set<Integer> list4 = new HashSet<>();
        for (int i = 0; i < 10; i++)
            list4.add(i);
        System.out.println(list1.getClass());
        System.out.println(method(list1).getClass());
        System.out.println(method(list1));

        System.out.println(list2.getClass());
        System.out.println(method(list2).getClass());
        System.out.println(method(list2));

        System.out.println(list3.getClass());
        System.out.println(method(list3).getClass());
        System.out.println(method(list3));

        System.out.println(list4.getClass());
        System.out.println(method(list4).getClass());
        System.out.println(method(list4));


    }
}
