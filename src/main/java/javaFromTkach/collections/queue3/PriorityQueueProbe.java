package javaFromTkach.collections.queue3;

import java.util.*;

/**
 * Created by Ежище on 16.01.2017.
 */
public class PriorityQueueProbe {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(); // чтобы превратить ее в Dequeue, чтобы появились addLast()  и т.п,
        // нужно сделать LinkedList<Integer> q = new LinkedList<>();
        for (int i = 5; i > 0; i--)
            q.add(i);
        System.out.print("LinkedList q: ");
        while (!q.isEmpty())
            System.out.print(q.poll() + " ");
        System.out.println();

        // LinkedList можно реализовать также следующим образом:
        List<Integer> lq = new LinkedList<>();
        // Но тогда он будет поддерживать второй интерфейс Queue, а не Dequeue

        Queue<Integer> aq = new ArrayDeque<>(); // Dequeue: чтобы появились addLast()  и т.п, нужно сделать
        // ArrayDeque<Integer> aq = new ArrayDeque<>();
         for (int i = 5; i > 0; i--)
            aq.offer(i);
        System.out.print("ArrayDeque aq: ");
        while (!aq.isEmpty())
            System.out.print(aq.poll() + " ");
        System.out.println();

        Queue<Integer> pq = new PriorityQueue<>(); // PriorityQueue - это только Queue, накаких Dequeue!
         for (int i = 5; i > 0; i--)
             pq.offer(i);
        System.out.print("PriorityQueue pq: ");
        while (!pq.isEmpty())
            System.out.print(pq.poll() + " ");
        System.out.println();

        // PriorityQueue ppq = new PriorityQueue(Collection или  Comparator)
        Collection<Integer> cq = new ArrayList<>();
//        for (int i = 0; i < 5; i++)
//            cq.add(pq.poll());
        for (int i = 5; i > 0; i--)
        cq.add(i);
//        Collections.sort((List)cq);
        System.out.print("Collection as new LinkedList cq: ");
        for (Iterator<Integer> iterator = cq.iterator(); iterator.hasNext();)
            System.out.print(iterator.next() + " ");
        System.out.println();

        // Очередь, которая вначале выводит четные в порядке возрастания, а потом нечетные:
        Queue<Integer> evenOddQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 2 == 0 && o2 % 2 != 0)
                    return -1;
                else if (o1 % 2 != 0 && o2 % 2 == 0)
                    return 1;
                else {
//                    thenComparing(new Comparator<Integer>() {
//                        @Override
//                        public int compare(Integer o1, Integer o2) {
//                            if (o1 > o2)
//                                return 1;
//                            if (o1 < o2)
//                                return -1;
//                            return 0;
//                        }
//                    });
                    return o1.compareTo(o2);
                    // TODO: вот это вполне работает вместо верхней записи:
//                return (o1 % 2 == 0 && o2 % 2 != 0) ? -1 : ((o1 % 2 != 0 && o2 % 2 == 0) ? 1 : o1.compareTo(o2));
                }
            }
        });
        evenOddQueue.addAll(cq);
        System.out.print("PriorityQueue evenOddQueue: ");
        while (!evenOddQueue.isEmpty())
            System.out.print(evenOddQueue.poll() + " ");
        System.out.println();
    }
}
