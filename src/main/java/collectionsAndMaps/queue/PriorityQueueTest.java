package collectionsAndMaps.queue;

import java.util.*;

/**
 * Created by Ежище on 30.12.2016.
 */
public class PriorityQueueTest {
    Comparator<Oyu> comparator = new Comparator<Oyu>() {
        @Override
        public int compare(Oyu o1, Oyu o2) {
            if (o1.x > o2.x) // странно, но только если расставить -1 и 1 в компараторе наоборот,
                // то он сортирует правильно, от меньшего к большему.
                return -1;
            else if (o1.x < o2.x)
                return 1;
            return 0;
        }
    };
    /**
     * Динамическое создание образцов класса - вполне работает:
     */
    public PriorityQueue<Oyu> dinamicSetQueue() {
        Queue<Oyu> pri = new PriorityQueue<Oyu>(5, comparator);
        for (int i = 0; i < 5; i++) {
            Oyu e = null;
            try {
                Class clazz = Class.forName("collectionsAndMaps.queue.Oyu"); //"java.lang.Object"
                e = (Oyu) clazz.newInstance();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
            pri.offer(e);
        }
        return (PriorityQueue<Oyu>) pri;
    }

    public PriorityQueue<Oyu> setQueue() {
        Queue<Oyu> pri = new PriorityQueue<Oyu>(5, comparator);
        for (int i = 6; i < 15; i+=2) {
            pri.offer(new Oyu((i + 50) / 2));
        }
        return (PriorityQueue<Oyu>) pri;
    }

    public static void main(String[] args) {
        PriorityQueueTest que = new PriorityQueueTest();
        Queue<Oyu> pri = que.dinamicSetQueue();
        pri.peek().x = 123;
        System.out.println(pri.poll().x + "\n" + pri.poll().x + "\n" + pri.poll().getClass().toString() + "\n" +
                pri.poll().toString());

        System.out.println();
        pri = que.setQueue();
        for (Iterator<Oyu> iterator = pri.iterator(); iterator.hasNext(); ) // с использованием итератора элементы
            // могут вызываться не в нужном порядке (например, здесь это происходит, если использовать
            // вот такой обратный компаратор). Нужно использовать для вызова элементов по порядку Arrays.set().
            System.out.println(iterator.next().x);
        System.out.printf("pri.poll().x = %d, pri.poll().x = %d, pri.poll().x = %d, pri.poll().x = %d, " +
                "pri.poll().x = %d", pri.poll().x, pri.poll().x, pri.poll().x, pri.poll().x, pri.poll().x);

        System.out.println("\n");
        pri = que.setQueue();
        Oyu [] array = new Oyu [pri.size()];
        pri.toArray(array);
        Arrays.sort(array, que.comparator);
        for (Oyu entry : array)
            System.out.print(", entry.x = " + entry.x);
    }
}

class Oyu {
    int x;

    Oyu() {
    }

    Oyu(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Oyu)
            return x == ((Oyu) object).x;
        return super.equals(object);
    }
}

