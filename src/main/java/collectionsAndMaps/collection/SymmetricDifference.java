package collectionsAndMaps.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Ежище on 29.01.2017.
 */
public class SymmetricDifference {
    public static <T> Collection<T> symmetricDifference (Collection<T> a, Collection<T> b) {
        Collection<T> intersection = new ArrayList<T>(a);
        intersection.retainAll(b);
        Collection<T> result = new ArrayList<T>(a);
        result.addAll(b);
        result.removeAll(intersection);
        return result;
    }

    public static void main(String[] args) {
        Collection<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 4, 5, 6, 7));
        Collection<Integer> b = new ArrayList<>(Arrays.asList(3, 4, 4, 5, 6, 7, 8, 9));
        Collection<Integer> c = symmetricDifference(a, b);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println();
    }
}
