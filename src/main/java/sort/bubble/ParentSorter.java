package sort.bubble;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 16.10.2016.
 */
public abstract class ParentSorter {
    /** индекс элемента, который при данной прорисовке сравнивается со следующим в списке (индекс пузырька) */
    public int j = 0;
    /** индекс элемента, до которого движется пузырек (справа от него все элементы уже отсортированы);
     * при k = count - 1 это индекс конца списка */
    public int k;
    /** чтобы при первой прорисовке списка он не был сразу сортированным на 1 шаг */
    public int transit = 0;
//    public int count;
    public ArrayList<Integer> sort(ArrayList<Integer> randomList){return randomList;}
    public int[] sort(int[] arr) {return arr;}
    public List<Integer> sort(List<Integer> randomList){return randomList;}
}
