package interview;

/**
 * Created by Ежище on 20.02.2017.
 */
public class A {
    void m1(){}
    void m2() {}
    void testPolimorph(A a) {}

    public static void main(String[] args) {
        A a = new B();
        a.m1();
        a.m2();
//        a.m3(); // ошибка компиляции
        a = (B)a;
        /* после явного приведения типов m3 появляется в списке подсказок, однако когда пытаешься его вызвать,
         * IDEA или JVM все равно представляет код в следующем виде: **/
        ((B) a).m3();

        B b = new B();
        A c = new A();
        B d = (B) (new A());
        a.testPolimorph(a);
        a.testPolimorph(b);
        a.testPolimorph(c);
        a.testPolimorph(d);




        System.out.println(Math.pow(2, 31) - 1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 15) - 1);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Math.pow(2, 7) - 1);
        System.out.println(Byte.MAX_VALUE);
    }
}
class B extends A {
    void m2() {}
    void m3() {}
}
