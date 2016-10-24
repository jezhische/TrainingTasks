package sort.quick;

import sort.bubble.ParentSorter;

import java.util.Random;

/**
 * Created by WORK on 24.10.2016.
 * https://dev64.wordpress.com/2013/07/24/quick-sort/
 */
public class QuickSort2_2Array extends ParentSorter {
//    int j;
    int count;
    int partition(int arr[], int j, int k) {
        this.j = j;
        int i = j, ir = k;
        int tmp;
        int pivot = arr[(j + k) / 2];

        while (i <= ir) {
            while (arr[i] < pivot)
                i++;
            while (arr[ir] > pivot)
                ir--;

            if (i <= ir) {
                tmp = arr[i];
                arr[i] = arr[ir];
                arr[ir] = tmp;
                i++;
                ir--;
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

    int[] getRandomArr() {
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
        for (int i = 0; i < count; i++)
            System.out.print(arr[i] + ", ");
    }

    @Override
    public int[] sort(int[] arr) {
        k = count - 1;
        quickSort(arr, j, k);
        return super.sort(arr);
    }

    public static void main(String[] args) {
        QuickSort2_2Array test = new QuickSort2_2Array();
        test.count = 25;
        int[] arr = test.getRandomArr();
        test.printArr(arr);
        System.out.println("");
        test.sort(arr);
        test.printArr(arr);

    }
}
