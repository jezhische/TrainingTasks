package reference.newRefProbes;

/**
 * Created by WORK_x64 on 17.08.2017.
 */
public class RefReleasing {
    A n;
    int i;
    public static void main(String[] args) {
        RefReleasing rr = new RefReleasing();
        System.out.println(rr.n);
//        System.out.println(rr.n.hashCode());
        System.out.println(rr.i);
        A a = new A();
        System.out.println(a.aaa);
        System.out.println(a.hhh);
        a = new B();
        System.out.println(a.hhh);
        B b = new B();
        b.hhh = 25;
        a = b;
        System.out.println(a.hhh);
        a = null;
        System.out.println(b.hhh);
        System.out.println(a);
    }

}
class A {
    int hhh = 5;
    int aaa;
    RefReleasing rr = new RefReleasing();
    public void print() {
        System.out.println(aaa);
    }
    {aaa = 56;}
}
class B extends A {
    {super.hhh = 10;}
}