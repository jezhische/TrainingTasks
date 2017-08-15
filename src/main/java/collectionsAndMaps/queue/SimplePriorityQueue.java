package collectionsAndMaps.queue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by Ежище on 19.02.2017.
 */
public class SimplePriorityQueue {
    /* PriorityQueue просто сортирует элементы. Интерфейс только Queue, Deque нет **/
    public static void main(String[] args) {
        Random rand = new Random();
        PriorityQueue<Integer> pri = new PriorityQueue<>(7);
        for (int i = 7; i > 0; i--)
            pri.offer(rand.nextInt(10));
        /* НО ИТЕРАТОР ИЛИ foreach ВОЗВРАЩАЕТ ЭЛЕМЕНТЫ В НЕПРАВИЛЬНОМ ПОРЯДКЕ. Чтобы вернуть их по порядку, нужно
         * перевести очередь в toArray, использовать там метод Arrays.sort(), и после вывести через петлю foreach **/
        for (Iterator<Integer> it = pri.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + ", ");
        }
        System.out.println();
        pri.forEach(integer -> System.out.print(integer + "/ "));
        System.out.println();

        /* А вот так порядок получается правильный: **/
        while(pri.peek() != null)
            System.out.print(pri.poll() + "* "); // если здесь использовать pri.peek(), будет бесконечный цикл

    }
}
