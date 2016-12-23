package heap.passingByValueOrReference;

/**
 * Created by WORK_x64 on 23.12.2016.
 */
public class ReferenceEquality {
    int a;
    String s;
    Object object;
    void objWork(Object object) {
        object = "qwerty";
        this.object = object;
        object = "222222222";
    }
    public static void main(String[] args) {
        String a = "kuku", b = "zozo";
        a = b;
        System.out.println("a = " + a);
        a = "ras";
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        b = "dfa";
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        ReferenceEquality ref = new ReferenceEquality();
        System.out.println("ref.object = " + ref.object);
        System.out.println("ref.a = " + ref.a);
        ref.objWork(ref.object);
        System.out.println("ref.object = " + ref.object);

//        Object obj = null;
//        System.out.println("obj = " + obj);
//        String s = "ggg";
//        obj = s;
//        System.out.println("obj = " + obj);
    }
}
