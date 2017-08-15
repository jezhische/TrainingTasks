package collectionsAndMaps.set;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Ежище on 23.07.2017.
 */
public class SetHashSorting {
    public static void main(String[] args) {
        SetHashSorting[] sets = new SetHashSorting[10];
        for (int i = 0; i < 10; i++) {
            sets[i] = new SetHashSorting();
        }
        HashSet<Object> set = new HashSet<>(Arrays.asList(sets));
        for (SetHashSorting setHashSorting : sets) {
            System.out.println(setHashSorting.hashCode());
        }
    }
}
