package cloneable.newProbes;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class CloneMyProbe implements Cloneable {
    private int initial;
    private Comparator<RandPoint> comparator = Comparator.comparing(RandPoint::getId);
    private Queue<RandPoint> prQueue;

    public CloneMyProbe(int initial) {
        this.initial = initial;
        prQueue = populateAndGetQueue();
    }
    public Queue<RandPoint> populateAndGetQueue() {
        Queue<RandPoint> orderedQueue = new PriorityQueue<>(initial, comparator);
        for (int i = 0; i < initial; i++) {
            orderedQueue.add(RandPoint.getRP(new Random().nextInt(100)));
        }
        return orderedQueue;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getInitial() {
        return initial;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public Comparator<RandPoint> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<RandPoint> comparator) {
        this.comparator = comparator;
    }

    public Queue<RandPoint> getPrQueue() {
        return prQueue;
    }

    public void setPrQueue(Queue<RandPoint> prQueue) {
        this.prQueue = prQueue;
    }
}
class RandPoint {
    private int id;

    private RandPoint(int id) {
        this.id = id;
    }
    static RandPoint getRP(int init) {
        return new RandPoint(init);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


class DoIt {
    public static void main(String[] args) {
        int initial = 5;
        CloneMyProbe original = new CloneMyProbe(initial);
        Queue<RandPoint> naturalOrderQueue = original.populateAndGetQueue();
        naturalOrderQueue.forEach(rp -> System.out.println(rp.getId()));


    }
}
