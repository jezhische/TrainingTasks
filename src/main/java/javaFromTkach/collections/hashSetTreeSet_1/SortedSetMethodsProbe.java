package javaFromTkach.collections.hashSetTreeSet_1;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Ежище on 08.01.2017.
 */
public class SortedSetMethodsProbe {
    static SortedSet<Integer> sortedset = new TreeSet<>(); // если сделать так:
    // NavigableSet<Integer> sortedset = new TreeSet<>(); - то сразу появляется много удобных новых готовых методов,
    // писать ничего не нужно. Интерфейс NavigableSet наследуется от SortedSet (который, в свою очередь, наследуется
    // от интерфейса Set), и TreeSet имплементирует именно NavigableSet, так что и создавать лучше объект NavigableSet.
    Integer getNextElem(Integer elem) {
        if (sortedset.contains(elem) && sortedset.tailSet(elem).size() > 1) {
            SortedSet<Integer>  temp = sortedset.tailSet(elem);
            temp.remove(elem);
            Integer nextElem = temp.first();
            sortedset.add(elem);
            return nextElem;
        }
        return -1;
    }

    Set<Integer> getPrevElems(Integer elem) {
        if (sortedset.contains(elem) && sortedset.headSet(elem).size() > 0)
            return sortedset.headSet(elem);
        return null;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            sortedset.add(i);
        SortedSetMethodsProbe sort1_1 = new SortedSetMethodsProbe();
        SortedSetMethodsProbe sort1_2 = new SortedSetMethodsProbe();

        System.out.println(sort1_1.getNextElem(5));
        System.out.println(sort1_1.getNextElem(9));
        System.out.println(sort1_2.getNextElem(4));

        System.out.println(sort1_2.getPrevElems(5));
        System.out.println(sort1_2.getPrevElems(0));
        System.out.println(sort1_1.getPrevElems(9));

    }
}
