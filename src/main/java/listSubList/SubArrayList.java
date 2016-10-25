package listSubList;

import sort.bubble.BubbleSortFull;
import swing._2Danimation.auxiliary.BubbleSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by WORK on 24.10.2016.
 */
public class SubArrayList {
    ArrayList<Integer> arrayList = new ArrayList<>();
        int count;
        public ArrayList<Integer> getArrayList() {
            for (int i = 0; i < count; i++)
                arrayList.add(i);
            Collections.shuffle(arrayList);
            return arrayList;
    }
    public void printArrayList(int count) {
        this.count = count;
        ArrayList<Integer> list = getArrayList();
        System.out.print("list =   " + list);
        ArrayList<Integer> leftSubList = new ArrayList<>(list.subList(0, count / 2));
        System.out.print("\nleftSubList = " + leftSubList);
        ArrayList<Integer> rightSubList = new ArrayList<>(list.subList(count / 2, count));
        System.out.print("\nrightSubList =                                           " + rightSubList);
        ArrayList<Integer> joinSubList = new ArrayList<>(count);
        joinSubList.addAll(leftSubList);
        joinSubList.addAll(rightSubList);
        System.out.print("\njoinSubList = " + joinSubList);

        List<Integer> lll = BubbleSort.sort(list.subList(0, count / 2)); // NB: это перегруженный метод sort для List<>, а не для ArrayList<>
        System.out.print("\nList<>!!! lll =   " + lll);
        System.out.print("\nlist =   " + list); // и вот половина исходного листа уже отсортирована!


        List<Integer> listlist = (List<Integer>) list;
        System.out.print("\nlistlist =   " + listlist);
        list = (ArrayList<Integer>) listlist;
        System.out.print("\nlist =   " + list);
        ArrayList<Integer> list3 = (ArrayList<Integer>) listlist;
        System.out.print("\nlist3 =   " + list3);

    }

    public static void main(String[] args) {
        new SubArrayList().printArrayList(25);
    }
}
