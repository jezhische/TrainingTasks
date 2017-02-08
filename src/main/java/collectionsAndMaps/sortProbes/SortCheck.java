package collectionsAndMaps.sortProbes;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by WORK_x64 on 08.02.2017.
 */
public class SortCheck {
    Collection<Integer> col = new ArrayList<>();
    ArrayList <Integer> arlist = new ArrayList<>();
//    Comparator<Integer> comparator = Integer::compareTo; // прикольно, так можно.
    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer x, Integer y) {
            return Integer.compare(x, y);
//            return (x < y) ? -1 : ((x == y) ? 0 : 1);
        }
    };
    void sort(List<Integer> arlist) {
//        col.sort(...) // нет такого в Collection!
        arlist.sort(Integer::compareTo); // а в ArrayList есть.
    }
    void sortWithComp(List<Integer> arlist) {
        arlist.sort(comparator);
    }

    public static void main(String[] args) {
        /* попробуем один из встроенных функциональных интерфейсов: **/
        Consumer<ArrayList<Integer>> printBefore = arlist -> System.out.printf("before sort %s = %s\n",
                arlist.getClass().getSimpleName(), arlist);


        SortCheck scheck = new SortCheck();
        scheck.arlist = new ArrayList<>(Arrays.asList(45, 12, 126, 12, 12, 645, 0, -25, -15, -15));
        printBefore.accept(scheck.arlist);
        System.out.println("before sort arlist = " + scheck.arlist);
        ArrayList <Integer> newAL = (ArrayList<Integer>) scheck.arlist.clone();
        System.out.println("before sort newAL = " + newAL);
        scheck.sort(scheck.arlist);
        scheck.sortWithComp(newAL);
        System.out.println("after sort with scheck.sort(scheck.arlist)  arlist = " + scheck.arlist);
        System.out.println("after sort with scheck.sortWithComp(newAL) newAL = " + newAL);
    }
}
