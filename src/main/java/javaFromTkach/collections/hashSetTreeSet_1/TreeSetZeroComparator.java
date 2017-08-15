package javaFromTkach.collections.hashSetTreeSet_1;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Ежище on 08.01.2017.
 */
public class TreeSetZeroComparator {
    static Set<Integer> tree = new TreeSet<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    });

    public static void main(String[] args) {
        tree.add(1);
        tree.add(2);
        tree.add(1);
        System.out.println(tree);
    }
}
