package cloneable.newProbes;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

public class CloneMyProbe implements Cloneable {
    private int initial;
    private Comparator<RandPoint> comparator = Comparator.comparing(RandPoint::getId);
    private Queue<RandPoint> prQueue;
    private String name;

    public CloneMyProbe(int initial, String name) {
        this.initial = initial;
        this.name = name;
        prQueue = populateAndGetQueue();
    }
    public Queue<RandPoint> populateAndGetQueue() {
        Queue<RandPoint> orderedQueue = new PriorityQueue<>(initial, comparator);
        for (int i = 0; i < initial; i++) {
            orderedQueue.add(RandPoint.getRP(new Random().nextInt(100)));
        }
        return orderedQueue;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

        @Override
    protected CloneMyProbe clone() throws CloneNotSupportedException {
        CloneMyProbe other = (CloneMyProbe) super.clone();
        other.setComparator(this.getComparator());
        Queue<RandPoint> otherQueue = new PriorityQueue<>(initial, comparator);
        Iterator<RandPoint> iterator = prQueue.iterator();
        while(iterator.hasNext()) {
            otherQueue.add(iterator.next());
        }
//        other.setPrQueue(prQueue);
        other.setPrQueue(otherQueue);
        other.setName(this.getName());
        return other;
    }

    @Override
    public String toString() {
        return this.getName() + ": initial - " + this.getInitial() + ", comparator - " + this.getComparator() +
                ", prQueue - " + this.getPrQueue();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public static void main(String[] args) throws CloneNotSupportedException {
        int initial = 5;
        CloneMyProbe original = new CloneMyProbe(initial, "Original");
//        Queue<RandPoint> naturalOrderQueue = original.populateAndGetQueue();
//        naturalOrderQueue.forEach(rp -> System.out.println(rp.getId()));
        CloneMyProbe clone = (CloneMyProbe) original.clone();
        System.out.println(original.toString());
        System.out.println(clone.toString());
        System.out.println();
        clone.getPrQueue().add(RandPoint.getRP(1));
        clone.setName("Clone");
        System.out.println(original.toString());
        System.out.println(clone.toString());


    }
}
