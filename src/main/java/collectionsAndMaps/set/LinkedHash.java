package collectionsAndMaps.set;

import java.util.*;

/**
 * Created by Ежище on 18.02.2017.
 */
public class LinkedHash {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhset = new LinkedHashSet<Integer>();
        int i = 0;
        while (i < 4) {
        lhset.add(i);
        i++;
        } while (i >= -1) {
            lhset.add(i);
            i--;
        }
        lhset.add(3); // вывод: 0, 1, 2, 3, 4, -1, - несмотря на то, что элементы сохраняются по порядку, повторяющиеся
        // элементы переписываются на то место, где они хранятся, а не вставляются по порядку
        lhset.forEach(j -> System.out.print(j + ", "));
    }
}
