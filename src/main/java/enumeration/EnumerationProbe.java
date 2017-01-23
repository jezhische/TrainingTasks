package enumeration;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Ежище on 22.01.2017.
 */
public class EnumerationProbe {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        for (int i = 10; i >= 0; i--)
            v.add(i);
        System.out.println(v);
        for (Enumeration<Integer> e = v.elements(); e.hasMoreElements(); )
            System.out.print(e.nextElement() + ", ");

        System.out.println();
        ArrayList<Integer> arr = new ArrayList<>(11);
        for (int i = 10; i >= 0; i--)
            arr.add(i);
        System.out.println(v);
        Vector<Integer> arrCopy = new Vector<>(arr);
        for (Enumeration<Integer> e = arrCopy.elements(); e.hasMoreElements(); )
            System.out.print(e.nextElement() + ", ");
        System.out.println();
        for (Iterator<Integer> iter = arrCopy.iterator(); iter.hasNext();)
            System.out.print(iter.next() + ", ");
    }
}
