package collectionsAndMaps.collection.newC;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionWork {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Collection col = list;

        list.add(1);
        list.add(1);
        list.add(1);

        list.remove(0);
        col.remove(0); // NB: у Collection есть только метод public boolean remove(Object o), который удаляет объект
        // (именно объект, а не найденный по индексу!), в то время как у List есть
        // переопределенный метод public E remove(int index)

        System.out.println("Размер list: " + list.size());
        System.out.println("Размер col: " + col.size());
    }
}
