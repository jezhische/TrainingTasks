package sort.quick.fromInet;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Ежище on 24.10.2016.
 * http://cybern.ru/qsort-java.html
 */
public class QuickSort1 {
    static Random rand = new Random();
    public static void qSort(List<Integer> array) {
        int n = array.size();
        int i = 0;
        int j = n-1;
        int x = array.get(rand.nextInt(n));
        while (i <= j) {
            while (array.get(i) < x) {
                i++;
            }
            while (array.get(j) > x) {
                j--;
            }
            if (i <= j) {
                Collections.swap(array,i,j);
                i++;
                j--;
            }
        }
        if (j>0){
            qSort(array.subList(0, j + 1));
        }
        if (i<n){
            qSort(array.subList(i,n));
        }
    }


}
