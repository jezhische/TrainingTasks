package collectionsAndMaps.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Ежище on 16.12.2016.
 */
public class IteratorRemoveProbe {

    private static boolean cond(Integer iterNext) { // cond (int iterNext) почему-то тоже прокатывает ниже
        return iterNext % 2 != 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> addlist = new ArrayList<>();
        for (int i = 10; i >= 0; i--)
            addlist.add(i); // добавляем int, но в листе происходит автоматическое оборачивание в Integer

        LinkedList<Integer> linkedList = new LinkedList<>(addlist);

        for (Iterator<Integer> iter = addlist.iterator(); iter.hasNext(); )
            if (!cond(iter.next()))
                iter.remove();

        System.out.println(addlist);

        for (Iterator<Integer> descIter = linkedList.descendingIterator(); descIter.hasNext(); )
            while (descIter.next() % 2 != 0)
                descIter.remove();

        System.out.println(linkedList);

        ArrayList<Integer> newList = new ArrayList<>();
        for (Iterator<Integer> descIter = linkedList.descendingIterator(); descIter.hasNext(); ) {
            newList.add(descIter.next());
        }

        System.out.println(newList);

        int i = 0;
        for (Iterator<Integer> descIter = linkedList.descendingIterator(); descIter.hasNext(); ) {
            linkedList.set(i, descIter.next());
            i++;
        }


        System.out.println(linkedList);
    }
}
