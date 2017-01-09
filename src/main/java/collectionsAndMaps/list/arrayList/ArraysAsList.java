package collectionsAndMaps.list.arrayList;

import java.util.*;

/**
 * Created by Ежище on 16.12.2016.
 */
public class ArraysAsList {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList( "2", "1", "2", "4", "3");
        System.out.println(stringList);
        Set<String> stringSet = new HashSet<String>( stringList );
        System.out.println(stringSet);
//        for( String entry : stringSet ){
//            System.out.print( entry );
//        }

        Integer[] arr = {1, 2, 3, 4, 5, 1, 5, 3, 2, 4};
        List<Integer> intList = Arrays.asList(arr);
//        Character[] str = {'f', 'd', 'f', 'g'};  // не получается copyOf
//        List<Character> copyList = Arrays.copyOf(str, 4);
        System.out.println(intList);
        Set<Integer> intSet = new HashSet<>(intList);
        System.out.println(intSet);

        ArrayList<Integer> a2 = new ArrayList<>(intList);
        System.out.println("a2 = " + a2);

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            al.add(arr[i]);
        System.out.println("al = " + al);
    }
}
