package garbage.constructor.newProbe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by WORK_x64 on 17.08.2017.
 */
public class CastProbe {
    public static void main(String[] args) {
        Object obj = new String();
//        obj = "aa";
        System.out.println(obj);

        Object obj2 = new Object();
        obj2 = 5;
        System.out.println(obj2);
        System.out.println(obj2.getClass());
        System.out.println(int.class);

        A a = new B();
        A aa = new A();

        System.out.println();
        aa.print(5);
//        B b = (B) aa;
//        aa = (B)aa;
        a.print(5);
        ((A)a).print(5);

        ((B)a).print();
        System.out.println();

        Class clazz = a.getClass().getSuperclass();
        try {
            A example = (A) clazz.getDeclaredConstructor(Integer.class).newInstance(5);
            Method methodHope = clazz.getDeclaredMethod("print", double.class);
            methodHope.invoke(example, 25);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println();

        ((B) a).print();
        C c = new C();

        B b = new B();
        Object aaa = b;
//        b = (Object)b;
        b.print();

        c.grab(aa);
        c.grab(b);
//        c.grab(aaa);

        Object o = new Object();
        System.out.println(o.getClass());
        o = "jjjjjj";
        System.out.println(o);
        System.out.println(o.getClass());


    }
}

class A {
    public A() {
    }
    public A(Integer a) {
    }

    public void print(double j) {
        System.out.println("AAAAA!");
    }
}

class B extends A {
    public void print() {
        System.out.println("Это B!!!");
    }

    @Override
    public void print(double j) {
        System.out.println("BBBBB!");
    }
}

class C {
    public void grab(A a) {
        System.out.println("Если это объект типа A, будет брошено исключение");
        try {
            ((B) a).print();
        } catch (ClassCastException e) {
            System.out.println("А вот и ClassCastException");
        }
    }
}
