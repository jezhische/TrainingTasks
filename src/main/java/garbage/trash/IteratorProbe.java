package garbage.trash;

import java.util.*;

/**
 * Created by WORK on 12.12.2016.
 */
public class IteratorProbe {
    public static void main(String[] args) {
        int i = 0;
        List<Integer> arl = new ArrayList<>();
        while (i < 10) {
            arl.add(i, i);
            i++;
        }
        System.out.println(arl);

        for (Integer a: arl)
            System.out.print(a + ",");
        System.out.println("");
        for (Iterator<Integer> iterator = arl.iterator(); iterator.hasNext();)
            System.out.print(iterator.next() + ",");
        System.out.println("");
        for (ListIterator<Integer> iterator = arl.listIterator(); iterator.hasNext();)
            System.out.print(iterator.next() + ",");
        System.out.println("");

        Iterator iter = arl.iterator();
//        while (iter.hasNext())
//            System.out.println(iter.next());
        for (int j = 0; j < arl.size(); j++)
            System.out.println(iter.next() + "," + arl.get(j));

        arl.add(5, 648);
        System.out.println(arl.get(5));

        LinkedList link = new LinkedList();
        link.getFirst();

        HashSet<Object> hash = new HashSet<>();

        LinkedHashSet<Object> lhash = new LinkedHashSet<>();


    }
}
