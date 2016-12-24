package heap.passingByValueOrReference;

/**
 * Created by Ежище on 23.12.2016.
 */
public class PassBy2 {
    int x;
    PassBy2 first;
    PassBy2 passObjectReference(PassBy2 first, PassBy2 second) {
        first = second;
        return first;
    }
    PassBy2 passThisReference(PassBy2 first, PassBy2 second) {
        this.first = first;
        first = second;
        return first;
    }

    public static void main(String[] args) {
        PassBy2 first = new PassBy2();
        first.x = 5;
        PassBy2 second = new PassBy2();
        second.x = 10;



    }
}
