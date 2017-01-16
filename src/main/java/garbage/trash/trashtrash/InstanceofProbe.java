package garbage.trash.trashtrash;

/**
 * Created by WORK_x64 on 14.12.2016.
 */
public class InstanceofProbe {
    class A {
        int a = 1;
    }
    class B extends A {}
    class C {}
    class D extends A {};

    public static void main(String[] args) {
        A a = new InstanceofProbe().new A();
        B b = new InstanceofProbe().new B();
        C c = new InstanceofProbe().new C();
        D d = new InstanceofProbe().new D();

        System.out.println(b instanceof A);
        System.out.println(a instanceof B);

        System.out.println(d instanceof A);
//        System.out.println(d instanceof B);

        System.out.println(a instanceof Object);
        System.out.println(new Object() instanceof A);

    }
}
