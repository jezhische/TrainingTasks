package objectMethods;

/**
 * Created by WORK_x64 on 17.01.2017.
 */
public class GetClassProbe {
    public static void main(String[] args) {
        // Вывод см. в конце.
        A a = new A();
        A ab = new B();
        B b = new B();
//        B ba = new FileWriterSimply();

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

        System.out.println(a instanceof A);
        System.out.println(b instanceof A);
        System.out.println(ab instanceof A);
        System.out.println(a instanceof B);
        System.out.println(b instanceof B);
        System.out.println(ab instanceof B);
        System.out.println();
        System.out.println(A.class.isInstance(a));
        System.out.println(A.class.isInstance(ab));
        System.out.println(A.class.isInstance(b));
        System.out.println();
        System.out.println(a.getClass() == A.class);
        System.out.println(ab.getClass() == A.class);
        System.out.println(d.getClass() == A.class);
        System.out.println(a.getClass() == B.class);
        System.out.println(ab.getClass() == B.class);
        System.out.println(b.getClass() == B.class);

        // Вывод: instanceof и isInstance согласны считать объект как образцом класса, от которого он создан, так и
        // образцом родителя. А getClass() дает точный класс, если это потомок - то никаких родителей.

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
