package genericClassesAndMethods.test.test5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ежище on 26.11.2016.
 */
public class GenericTypeIteratorTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        list.add("First");
        list.add("Second"); // если сделать list.add(10); , получим всего лишь ошибку компиляции - так безопаснее
        List list2 = list;
        for(Iterator<String> itemItr = list2.iterator(); itemItr.hasNext();) // типа
            // "for (int i = 0; i < list2.size(); i++)", но здесь вместо "int i = 0;" создается объект типа Iterator<E>
            // с помощью метода iterator(), затем ставится булевское условие itemItr.hasNext(); вместо i < list2.size();
            // , а третья позиция i++; пропущена - итератор сам знает, что нужно сделать при выполнении условия.
            System.out.println(itemItr.next());
//        можно сделать здесь foreach:
        for (String aList2 : (Iterable<String>) list2) System.out.println(aList2);
    }

}
