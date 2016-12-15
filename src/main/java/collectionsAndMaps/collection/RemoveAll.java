package collectionsAndMaps.collection;

import java.util.ArrayList;

/**
 * Created by Ежище on 15.12.2016.
 */
public class RemoveAll {
    int o;
    RemoveAll(int o) {this.o = o;}
    public static void main(String[] args) {
        Integer[] ii = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        RemoveAll [] rall = new RemoveAll[10];
        for (RemoveAll ra: rall) {
            int o = 0;
            ra = new RemoveAll(o);
            o++;
        }
        ArrayList<Integer> addlist = new ArrayList<>();
        for (int i = ii.length-1; i >= 0; i--)
            addlist.add(ii[i]);
        ArrayList<Integer> removelist = new ArrayList<>();
        for (int i = 5; i < 8; i++)
            removelist.add(addlist.get(i));
        ArrayList<Integer> arrlist = new ArrayList<>();
        arrlist.addAll(addlist);
        System.out.println("arrlist " + arrlist);
        System.out.println("removelist " + removelist);
        System.out.println("arrlist.removeAll(removelist) = " + arrlist.removeAll(removelist));
        System.out.println("arrlist.removeAll(removelist) = " + arrlist.removeAll(removelist));
        System.out.println("arrlist " + arrlist);
        ArrayList<Integer> retainlist = new ArrayList<>();
        for (int i = 4; i > 1; i--)
            retainlist.add(addlist.get(i));
        System.out.println("retainlist " + retainlist);
        System.out.println("arrlist.retainAll(retainlist) = " + arrlist.retainAll(retainlist));
        System.out.println("arrlist.retainAll(retainlist) = " + arrlist.retainAll(retainlist));
        System.out.println("arrlist " + arrlist);
    }
}
