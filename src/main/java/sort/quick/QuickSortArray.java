package sort.quick;

import sort.bubble.ParentSorter;

import java.util.Random;

/**
 * Created by WORK on 24.10.2016.
 * https://dev64.wordpress.com/2013/07/24/quick-sort/
 */
public class QuickSortArray extends ParentSorter {
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

    private void quickSort(int arr[], int left, int right) {
//        int a = arr[arr.length - 1];
        int leftIndex, rightIndex;
        leftIndex = left;
        rightIndex = right;
        int pivot = arr[leftIndex + (rightIndex - leftIndex) / 2];
//        int pivot = arr[new Random().nextInt(arr.length)]; // что интересно, со случайным pivot метод часто
// //срабатывает с очень явно видной задержкой
        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] < pivot)
                leftIndex++;
            while (arr[rightIndex] > pivot)
                rightIndex--;

            if (leftIndex < rightIndex) {
                int tmp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = tmp;
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
            quickSort(arr, left, leftIndex - 1);
        if (leftIndex < right) // условие определения правого subarray
            quickSort(arr, leftIndex, right);
    }

    private int[] getRandomArr(int count) {
        int [] arr = new int[count];
        Random rnd = new Random();
        for (int i = 0; i < count; i++)
            arr[i] = i;
        for (int i = 0; i < count; i++) {
            int index = rnd.nextInt(count);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;
    }
    private void printArr(int[] arr) {
        for (int value: arr)
            System.out.print(value + ", ");
    }

    @Override
    public int[] sort(int[] arr) {
        k = arr.length - 1;
        quickSort(arr, j, k);
        return super.sort(arr);
    }

    public static void main(String[] args) {
        QuickSortArray test = new QuickSortArray();
//        test.count = 25;
        int[] arr = test.getRandomArr(9);
        test.printArr(arr);
        System.out.println("");
//        test.quickSort(arr, 0, 8);
        test.sort(arr);
        test.printArr(arr);

    }
}
