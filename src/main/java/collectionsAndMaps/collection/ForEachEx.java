package collectionsAndMaps.collection;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;

import java.util.*;

/**
 * Created by WORK_x64 on 17.02.2017.
 */
public class ForEachEx {
    private static void accept(int i) {
        System.out.print(i + "/ ");;
    }
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 10; i > 0; i--)
            hashSet.add(i);

        for (Iterator<Integer> iterator = hashSet.iterator(); iterator.hasNext();)
            System.out.print(iterator.next() + ", ");
        System.out.println();
        for (Integer i : hashSet) System.out.print(i + ", ");
        System.out.println();

        hashSet.forEach(ForEachEx::accept);
        System.out.println();
        hashSet.forEach(System.out::print);
        System.out.println();
        hashSet.forEach(integer -> System.out.print(integer + ": ")); // лямба такая:
        // (integer) -> System.out.print(integer + ": "), но для единичного аргумента скобки опускаются
        System.out.println();

        ArrayList<String> as = new ArrayList<>(5);
        StringBuilder sbuild = new StringBuilder("a");
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++)
                sbuild.append((char)rand.nextInt(150));
            as.add(sbuild.toString());
            sbuild = new StringBuilder("a");
        }
        HashSet<ArrayList<String>> arSet = new HashSet<>();
        for (int i = 0; i < 3; i++)
            arSet.add(as);

        Spliterator<ArrayList<String>> spliterator = arSet.spliterator();
//        spliterator.forEachRemaining(System.out::print);
        Spliterator<ArrayList<String>> spliterator2 = spliterator.trySplit();
        spliterator2.tryAdvance(System.out::print);
        System.out.println();
        for (Iterator<ArrayList<String>> iterator = arSet.iterator(); iterator.hasNext();)
            System.out.print(iterator.next() + "___");
//        System.out.println();
//        arSet.forEach(System.out::print);
    }
}
