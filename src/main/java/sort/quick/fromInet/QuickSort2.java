package sort.quick.fromInet;

import java.util.Random;

/**
 * Created by WORK on 24.10.2016.
 * https://dev64.wordpress.com/2013/07/24/quick-sort/
 */
public class QuickSort2 {
    int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;

            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    static int count;

    static int[] getRandomArr() {
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
    static void printArr(int[] arr) {
        for (int i = 0; i < count; i++)
            System.out.print(arr[i] + ", ");
    }

    public static void main(String[] args) {
        count = 50;
        int[] arr = getRandomArr();
        printArr(arr);
        System.out.println("");
        new QuickSort2().quickSort(arr, 0, count - 1);
        printArr(arr);

    }
}
