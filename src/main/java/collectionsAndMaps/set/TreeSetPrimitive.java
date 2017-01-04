package collectionsAndMaps.set;

import java.util.TreeSet;

/**
 * Created by Ежище on 03.08.2016.
 */
public class TreeSetPrimitive {
    static TreeSet<Integer> tree = new TreeSet<>();
//    public static void add(int a) {
//        tree.add(a);
//    }

    public static void main(String[] args) {
        tree.add(2);
        tree.add(3);
        tree.add(3);
        tree.add(2);
        tree.add(5);
        tree.add(1);
        tree.add(-6);
        tree.add(-12);
        for (int a: tree) {
            System.out.println(a);
            }
    }
}
