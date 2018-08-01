package collectionsAndMaps.list.newL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArraysAsListUnmodified {
    public static void main(String[] args) {
        String[] str = new String[] { "1", "2", "3" };

//        To create modified List:
        List modifiedList = new ArrayList<>(Arrays.asList(str));

        for (Iterator iterator = modifiedList.iterator(); iterator.hasNext();) {
            Object object = (Object) iterator.next();
            iterator.remove();
        }
        System.out.println(modifiedList.size());



//        Attempt to modify unmodified List
        List unmodifiedList = Arrays.asList(str);

// To be UnsupportedOperationException: method Arrays.asList() returns UNMODIFIED ArrayList ("...Returns a fixed-size
// list backed by the specified array")
        for (Iterator iterator = unmodifiedList.iterator(); iterator.hasNext();) {
            Object object = (Object) iterator.next();
            iterator.remove();
        }
        System.out.println(unmodifiedList.size());
    }

}
