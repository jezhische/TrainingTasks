package garbage;

public class AssertProbe {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        int i = 5 + 5;
        assert (i != 10): "false";
        System.out.println(i);

    }
}
