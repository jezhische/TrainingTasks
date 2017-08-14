package garbage.trash;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ежище on 10.08.2017.
 */
public class ListInfinityCycle {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list = new ArrayList<Integer>(list); // надо же, прошло!
        System.out.println(list);
//        list.add(6, 75); // and here is IndexOutOfBoundsException!
    }
}
