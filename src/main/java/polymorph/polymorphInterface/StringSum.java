package polymorph.polymorphInterface;

/**
 * Created by Ежище on 18.12.2016.
 */
public class StringSum implements Summable {
    private String first, second;
    public String result;
    StringSum(String first, String second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public void sum() {
        result = first + second;
    }
}
