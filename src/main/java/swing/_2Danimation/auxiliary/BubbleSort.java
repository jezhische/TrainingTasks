package swing._2Danimation.auxiliary;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by WORK on 12.10.2016.
 */
public class BubbleSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> series) {
        Collections.shuffle(series);
        for (int k = series.size() - 1; k > 0; k--) {
            for (int j = 0; j < k; j++) {
                if (series.get(j) > series.get(j + 1)) {
                    Collections.swap(series, j, j + 1);
                }
            }
        }
        return series;
    }
}
