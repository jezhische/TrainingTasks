package objectMethods;

/**
 * Created by WORK_x64 on 17.01.2017.
 */
public class GetClassProbe {
    public static void main(String[] args) {
        A a = new A();
        A ab = new B();
        B b = new B();
//        B ba = new A();

        Object ggg = new String();
        System.out.println(ggg.getClass());
        System.out.println(((String)ggg).getClass());

        String s = "sdf";
        Object oo = s;
        System.out.println(s);
        System.out.println(oo);
        System.out.println(s.getClass());
        System.out.println(oo.getClass());
        String ss = (String)oo;
        Object fff = new Object();
//        String sss = (String) fff; // компилятор пропускает, в рантайме эксепшен.

        b.ddd();
        ((B)ab).ddd();
//        ((B)a).ddd(); // компилятор пропускает, в рантайме эксепшен.
        A aaa = b;

        A c = a;
        A d = b;
        B e = (B) ab;
//        B f = (B) a; // компилятор пропускает, в рантайме эксепшен.

        System.out.println(a.getClass());
        System.out.println(ab.getClass());
        System.out.println(b.getClass());

        B test = new B();
        Object obj = test;
        A aTest = (A) obj;
        aTest.print();

    }
}
class A {
    public void print () {
        System.out.println("Basic method");
    }
}
class B extends A {
    public void ddd () {}
    @Override
    public void print () {
        System.out.println("Override method");
    }
}
