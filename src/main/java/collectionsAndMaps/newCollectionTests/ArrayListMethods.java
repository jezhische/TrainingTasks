package collectionsAndMaps.newCollectionTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMethods {
    static void printArray(Object[] array) {
        try {
            System.out.println(Arrays.asList(array));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: array is null");
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 15, 8, 25);
        Integer[] integers = {};
        integers = list.toArray(integers); // 1 способ
        printArray(integers);
        integers = null;
        integers = (Integer[])list.toArray(); // 2 способ
        printArray(integers);
        integers = null;
        integers = list.toArray(new Integer[list.size()]); // 3 способ
        printArray(integers);
        integers = null;

        try {
//            list.add(23);
//            list.remove(0);
            list.set(0, 593);
            System.out.println(list);
            // а вот так можно:
            list = new ArrayList<>(list);
            list.add(256987);
            System.out.println(list);
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: в списке, созданном как asList(), нельзя добавлять " +
                    "или удалять элементы, можно только изменять их");
        }
    }

}
