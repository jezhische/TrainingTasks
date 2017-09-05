package collectionsAndMaps.list.newL;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIter {
    public static void main(String[] args) {
        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            link.add(i);
        }

        ListIterator<Integer> listIter = link.listIterator(2);
        while(listIter.hasNext())
            System.out.println(listIter.next());
        System.out.println();

        listIter = link.listIterator();

        System.out.println();
        // todo: NB: listIterator(link.size()) (иначе начнет с index = 0 и ничего не выведет)
        for (ListIterator<Integer> it = link.listIterator(link.size()); it.hasPrevious();) {
            System.out.print(it.previous() + "; ");
        }
        System.out.println();


        while(listIter.hasNext()) {
            Integer i = listIter.next();
            if (i == 1)
                listIter.set(-8);
            else if (i == 2) {
                System.out.println(listIter.previous());
                listIter.next();}
            else if (listIter.nextIndex() == 4)
                listIter.remove();
            System.out.println(i);
        }
        System.out.println();
        System.out.println(link);
        System.out.println();
    }
}
