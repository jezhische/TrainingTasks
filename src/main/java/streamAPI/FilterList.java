package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ежище on 04.08.2017.
 */
public class FilterList {
    public static void main(String[] args) {
        ArrayList<Integer> beforeList = new ArrayList<>(Arrays.asList(5, 15, 45, 89,-25, -16, 8, -76, 13, -84));
        ArrayList<Integer> afterList = new ArrayList<>();
        beforeList.stream().filter(i -> i >= -25 && i < 45).sorted().forEachOrdered(i -> afterList.add(i));
        afterList.forEach(i -> System.out.print(i + "; "));
    }
}
