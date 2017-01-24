package heap.passingByValueOrReference;

/**
 * Created by Ежище on 24.01.2017.
 */
public class TestInteger {
    static Integer a = new Integer(5);
    static int b = 10;
    public static Integer changeInteger(Integer any) {
        any = 666;
        return any;
    }
    public static int changeInt(int any) {
        any = 666;
        return any;
    }

    public static void main(String[] args) {
        changeInteger(a);
        changeInteger(b);
        System.out.println("after changeInteger  a = " + a);
        System.out.println("after changeInteger  b = " + b);
        changeInt(b);
        System.out.println("after changeInt  b = " + b);
    }
}
