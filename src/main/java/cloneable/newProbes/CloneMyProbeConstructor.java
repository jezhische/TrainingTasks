package cloneable.newProbes;

import java.util.*;

public class CloneMyProbeConstructor {

    private int initial;
    private Comparator<RandPoint> idComparator = ((thisRandPoint, thatRandPoint) ->
            thisRandPoint.getId() < thatRandPoint.getId()? -1 : thisRandPoint.getId() > thatRandPoint.getId()? 1 : 0);
    private Comparator<RandPoint> comparator = idComparator./*thenComparing((randPoint, string)
            -> this.getName().compareTo(randPoint.getName()));*/ thenComparing(Comparator.comparing(RandPoint::getName));

    private Queue<RandPoint> prQueue;
    private String name;

    public CloneMyProbeConstructor(int initial, String name) {
        this.initial = initial;
        this.name = name;
        prQueue = populateAndGetQueue();
    }

    public CloneMyProbeConstructor(int initial, Comparator<RandPoint> comparator, Queue<RandPoint> prQueue, String name) {
        this.initial = initial;
        this.comparator = comparator;
        this.prQueue = prQueue;
        this.name = name;
    }

    // конструктор клонирования:
    public CloneMyProbeConstructor(CloneMyProbeConstructor that) {
        this(that.getInitial(),that.getComparator(), that.getPrQueue(), that.getName());
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
        StringBuilder stringBuilder = new StringBuilder();
        getPrQueue().forEach((randomPoint) -> stringBuilder.append("id: " + randomPoint.getId() +
                ", name: " + randomPoint.getName() + "; "));
        return this.getName() + ": initial - " + this.getInitial() + ", comparator - " + this.getComparator() +
                ", prQueue - " + this.getPrQueue() + ": " + stringBuilder;
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

    public static void main(String[] args) {

        CloneMyProbeConstructor original = new CloneMyProbeConstructor(5, "Original");
        CloneMyProbeConstructor clone = new CloneMyProbeConstructor(original);
        clone.getPrQueue().peek().setName("HARAMBA!");
        System.out.println(original);
        System.out.println(clone);

    }
}
