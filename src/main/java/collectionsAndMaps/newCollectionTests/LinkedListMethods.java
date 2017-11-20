package collectionsAndMaps.newCollectionTests;

import java.util.*;

public class LinkedListMethods {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        ((LinkedList) list).peekFirst();
        ((Deque<Integer>) list).peek();

        list.addAll(Arrays.asList(15, 25, 4, 18, 8, 13, 26, 17));
        System.out.println(((LinkedList) list).peekFirst());
        System.out.println(((Deque<Integer>) list).peek()); // FIFO!
        System.out.println(((Deque<Integer>) list).peekLast());

        // как получить ConcurrentModificationException:
//        for (Integer integer : list) { // здесь идет обращение к итератору (?)
//            System.out.println(((LinkedList) list).poll());
//        }

        // еще как получить ConcurrentModificationException:
//        list.forEach(integer -> {
//            System.out.print(integer + "; ");
//            ((LinkedList) list).remove(integer);
//        });
        // а вот так пропустим вторую половину элементов, поскольку list.size() будет сокращаться:
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(((LinkedList) list).poll() + "; ");
//        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.print(((LinkedList) list).poll() + "; ");
        }
        System.out.println();
        list.addAll(Arrays.asList(15, 25, 4, 18, 8, 13, 26, 17));

//        Iterator iterator = list.iterator();
//        iterator.forEachRemaining(integer -> {
//            System.out.print(integer + "; ");
//            iterator.remove();
//        });

        for (Iterator iterator = ((LinkedList) list).descendingIterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + "; ");
            iterator.remove();
        }

    }
}
