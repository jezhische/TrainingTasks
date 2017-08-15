package polymorph.polymorphInterface;

/**
 * Created by Ежище on 18.12.2016.
 */
public class IntSum implements Summable {
    private int first, second;
    public int result;
    IntSum(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void sum() {
        result = first + second;
    }
}
