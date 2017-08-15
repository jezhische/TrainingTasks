package collectionsAndMaps.collection;

import java.util.*;

/**
 * Created by Ежище on 29.01.2017.
 */
public class IteratorExc {
    public static void main(String[] args) {
        /*
         * Исследование, что будет, если создать итератор для коллекции, затем удалить у коллекции один элемент,
         * а затем попытаться вызвать у итератора метод next() (будет java.util.ConcurrentModificationException)
        **/
        Collection<Integer> col = new ArrayList<>(Arrays.asList(5, 46, 12, 35, 546));
        System.out.println(col);
        System.out.println(col.remove(546));
        System.out.println(col);
        Iterator iter = col.iterator();
        System.out.println(((Integer)(iter.next())).toString() + ((Integer)(iter.next())).toString() +
                ((Integer)(iter.next())).toString());
        iter.remove();
        System.out.println(col);
        System.out.println(col.remove(35));
        System.out.println(col);
//        System.out.println(iter.next()); // java.util.ConcurrentModificationException
        Collections.reverse((List)col);
        System.out.println(col);
//        System.out.println(iter.next()); // java.util.ConcurrentModificationException
    }
}
