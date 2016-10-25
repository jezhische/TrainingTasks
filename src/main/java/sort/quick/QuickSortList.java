package sort.quick;

import sort.bubble.ParentSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by WORK on 24.10.2016.
 * https://dev64.wordpress.com/2013/07/24/quick-sort/
 */
public class QuickSortList extends ParentSorter {
//    private int partition(int arr[], int left, int right) { // создает pivot, сортируя 2 части массива слева и справа от
//        // выбранного где-то посередине значения, и затем возвращает индекс этого pivot
//        int tmp;
//        int pivot = arr[left + (right - left) / 2];
////        int pivot = arr[new Random().nextInt(arr.length)]; // что интересно, со случайным pivot часто срабатывает с
////// очень явно видной задержкой
//
//        while (left <= right) {
//            while (arr[left] < pivot)
//                left++;
//            while (arr[right] > pivot)
//                right--;
//
//            if (left <= right) {
//                tmp = arr[left];
//                arr[left] = arr[right];
//                arr[right] = tmp;
//                left++;
//                right--;
//            }
//        }
//        return left;
//    }

    private int count;

    private void quickSort(List<Integer> rndList, int left, int right) {
//        int a = arr[arr.length - 1];
        int leftIndex, rightIndex;
        leftIndex = left;
        rightIndex = right;
        int pivot = rndList.get(leftIndex + (rightIndex - leftIndex) / 2);
//        int pivot = arr[new Random().nextInt(arr.length)]; // что интересно, со случайным pivot метод часто
// //срабатывает с очень явно видной задержкой
        while (leftIndex <= rightIndex) {
            while (rndList.get(leftIndex) < pivot)
                leftIndex++;
            while (rndList.get(rightIndex) > pivot)
                rightIndex--;

            if (leftIndex < rightIndex) {
                Collections.swap(rndList, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            } else if (leftIndex == rightIndex) {  // условие = здесь нужно для того, чтобы после leftIndex++; и rightIndex--;
                // получилось leftIndex > rightIndex, и произошел бы выход из внешнего цикла
                leftIndex++;
                rightIndex--;
            }
        }


//        int index = partition(arr, left, right);
        if (left < leftIndex - 1) // условие определения левого subarray
            quickSort(rndList.subList(left, leftIndex - 1), left, leftIndex - 1);
        if (leftIndex < right) // условие определения правого subarray
            quickSort(rndList.subList(leftIndex, right), leftIndex, right);
    }

    private ArrayList<Integer> getRandomList() {
        ArrayList<Integer> randomList = new ArrayList<>(count);
        for (int i = 0; i < count; i++)
            randomList.add(i);
        Collections.shuffle(randomList);
        return randomList;
    }

    private void printList(int count) {
        this.count = count;
        ArrayList<Integer> randomList = getRandomList();
        System.out.print("randomList = " + randomList);
        System.out.println("");
        sort(randomList);
        System.out.print("randomList = " + randomList);
    }

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> randomList) {
        List<Integer> rndList = (List<Integer>) randomList;
        k = rndList.size() - 1;
//        k = count - 1;
        quickSort(rndList, j, k);
        randomList = (ArrayList<Integer>)rndList;
        return randomList;
    }

    public static void main(String[] args) {
        new QuickSortList().printList(9);
//        System.out.println(new Random().nextInt(5));
    }
}
