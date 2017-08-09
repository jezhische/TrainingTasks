package collectionsAndMaps.newProbes;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by WORK_x64 on 09.08.2017.
 */
public class SetAddArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(25, 15, 27, 17));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, new Random().nextInt(10));
        }
        System.out.println(list);

        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.add(i, new Random().nextInt(10));
        }
        System.out.println(list);
    }
}
