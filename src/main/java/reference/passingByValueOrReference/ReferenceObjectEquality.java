package reference.passingByValueOrReference;

/**
 * Created by WORK_x64 on 23.12.2016.
 */
public class ReferenceObjectEquality {
    Integer x;
    public static void main(String[] args) {
        ReferenceObjectEquality first = new ReferenceObjectEquality();
        ReferenceObjectEquality second = new ReferenceObjectEquality();
        first.x = 5;
        second.x = 10;
        first = second;
        System.out.println("first.x = " + first.x);
        first.x = 20;
        System.out.println("first.x = " + first.x);
        System.out.println("second.x = " + second.x);
        second.x = 30;
        System.out.println("first.x = " + first.x);
        System.out.println("second.x = " + second.x);
    }
}
