package sort.quick;

import sort.bubble.ParentSorter;

import java.util.Random;

/**
 * Created by WORK on 24.10.2016.
 * https://dev64.wordpress.com/2013/07/24/quick-sort/
 */
public class QuickSort2_2Array extends ParentSorter {
    int partition(int arr[], int left, int right) { // создает pivot, сортируя 2 части массива слева и справа от
        // выбранного где-то посередине значения, и затем возвращает индекс этого pivot
        int tmp;
        int pivot = arr[left + (right - left) / 2];
//        int pivot = arr[new Random().nextInt(arr.length)]; // что интересно, со случайным pivot часто срабатывает с
//// очень явно видной задержкой

        while (left <= right) {
            while (arr[left] < pivot)
                left++;
            while (arr[right] > pivot)
                right--;

            if (left <= right) {
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }

    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    int[] getRandomArr(int count) {
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
    void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ", ");
    }

    @Override
    public int[] sort(int[] arr) {
        k = arr.length - 1;
        quickSort(arr, j, k);
        return super.sort(arr);
    }

    public static void main(String[] args) {
        QuickSort2_2Array test = new QuickSort2_2Array();
//        test.count = 25;
        int[] arr = test.getRandomArr(25);
        test.printArr(arr);
        System.out.println("");
        test.sort(arr);
        test.printArr(arr);

    }
}
