package collectionsAndMaps.list.arrayList;

import java.util.ArrayList;

/**
 * Created by Ежище on 08.01.2017.
 */
// эффективный алгоритм для удаления m элементов из эррейлиста, начиная с n элемента
// Правда, не знаю, насколько эффективный: не удается пока просто replace все элементы, начиная от n + m, на
// m элементов влево - это было бы проще всего.
public class ArrayListRemoveElements {
    // вот сложный метод:
    static <T> ArrayList<T> removeMTailElements(ArrayList<T> list, int nIndexFrom, int mCount) {
        if (list.size() <= nIndexFrom + mCount && list.size() > nIndexFrom) {
            for (int j = list.size() - 1; j >= nIndexFrom; j--)
                list.remove(j);
        } else if (list.size() > nIndexFrom + mCount) {
            for (int i = nIndexFrom; i < list.size() - mCount; i++)
//            list.replaceAll(); // TODO: learn it
                list.set(i, list.get(i + mCount));
            int oldSize = list.size();
            for (int k = list.size() - 1; k >= oldSize - mCount; k--)
                list.remove(k);
        }
        return list;
    }

    // а вот простой метод:
    static <T> ArrayList<T> removeSublistMTailElements(ArrayList<T> list, int nIndexFrom, int mCount) {
        if (list.size() <= nIndexFrom + mCount && list.size() > nIndexFrom && nIndexFrom >= 0) {
            list.subList(nIndexFrom, list.size()).clear();
        } else if (list.size() > nIndexFrom + mCount && nIndexFrom >= 0) {
            list.subList(nIndexFrom, nIndexFrom + mCount).clear();
        } else if (nIndexFrom > list.size() - 1 || nIndexFrom < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.print("Index is out of arrayList bounds; arrayList is no changed: ");
//                e.getMessage();
                return list;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(i);

        list = removeSublistMTailElements(list, 5, 3);
        System.out.println(list);
        list = removeSublistMTailElements(list, 5, 3);
        System.out.println(list);
        list = removeSublistMTailElements(list, 5, 3);
        System.out.println(list);
        list = removeSublistMTailElements(list, 15, 3);
        System.out.println(list);
        list = removeSublistMTailElements(list, 0, 3);
        System.out.println(list);
        list = removeSublistMTailElements(list, -10, 3);
        System.out.println(list);

//        list = removeMTailElements(list, 5, 3);
//        System.out.println(list);
//        list = removeMTailElements(list, 5, 3);
//        System.out.println(list);
//        list = removeMTailElements(list, 5, 3);
//        System.out.println(list);
//        list = removeMTailElements(list, 15, 3);
//        System.out.println(list);
    }
}
