package garbage.trash.testprobes;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by WORK_x64 on 13.01.2017.
 */
public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
            al.add(i);
        long t2 = System.currentTimeMillis();
        System.out.println(String.format("ArrayList has been created for %dms.", (t2 - t1)));
        for (int i = 0; i < 1000000; i++)
            ll.add(i);
        long t3 = System.currentTimeMillis();
        System.out.println(String.format("ArrayList has been created for %dms with add method.", (t3 - t2)));
        al.add(500000, 555);
        long t4 = System.currentTimeMillis();
        System.out.println(String.format("Insertion in the middle of ArrayList has been performed for %dms with " +
                        "add method.", (t4 - t3)));
        ll.add(500000, 555);
        long t5 = System.currentTimeMillis();
        System.out.println(String.format("Insertion in the middle of ArrayList has been performed for %dms with " +
                "add method.", (t5 - t4)));
    }
}
