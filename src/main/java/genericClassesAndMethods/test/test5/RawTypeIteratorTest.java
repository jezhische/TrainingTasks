package genericClassesAndMethods.test.test5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ежище on 26.11.2016.
 */
public class RawTypeIteratorTest {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("First");
        list.add("Second"); // если сделать list.add(10); , получим ошибку времени выполнения
        List<String> list2 = list;
        for(Iterator<String> itemItr = list2.iterator(); itemItr.hasNext();)
            System.out.println(itemItr.next());
    }
}
