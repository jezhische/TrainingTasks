package inheritanceThisSuper.newConstructorSimple;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        System.out.println("B type object: " + new B().toString());
        System.out.println("Casting to A type: " + ((A)new B()).toString()); // повышающее приведение возможно

        A a = new B();
        System.out.println("Creating A type object by B instance: " + a.toString()); // late binding worked here!

        // Чтобы обратиться к методу суперкласса, а не к переопределенному уже методу потомка:
        System.out.println();
        Class classA =  a.getClass().getSuperclass(); //или так: Class<A> classA =  (Class<A>)a.getClass().getSuperclass();
        try {
            Method aToString = classA.getMethod("toString", null);
            System.out.println(aToString.invoke(classA.getDeclaredConstructor(int.class).newInstance(5), null));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println();

//        a.print(); // так нельзя. Можно так:
        ((B)a).print();

        B kb = new B();
        A ka = (A) kb;


        A aa = new A(5);
//        A b = (B) aa; // так нельзя, хотя компилятор пропустит! Понижающее приведение невозможно, поскольку в объекте
//         // чистого типа A нет дополнительной функциональности, которая появляется в типе B. Но из-за позднего
//        // связывания реальный тип объекта будет определен только в runtime.
//        B bb = (B) aa; // Так, соответственно, тоже нельзя.
        System.out.println("Instance of pure type A: " + aa.toString());
//        ((B)aa).print(); // компилятор пропустит, но в runtime выскочит ошибка.

//        B b = (B) new A(25); // ClassCastException
        B b = (B) a;

        //------------------------------------------------------------------------------
        // upcasting:
        A ad = new B(); // переменной типа В формально указывается тип А, поэтому только в данном случае
        // возможен downcasting:
        B bd = (B) ad;

        // upcasting:
        Object s = "upcasting String to Object";
        // downcasting:
//        String ss = new Object(); // incompatible types
//        s.contains(); // уже нельзя
        ((String)s).contains("dodo");

        int i = 1321346576;
        // downcasting
        short sh = (short)i;
        System.out.println(sh);

        bd.test1();
        aa.test1();
        ((A)bd).test1(); // todo: идет обращение к STATIC методу именно класса A!!!!
//        ((B)aa).test1(); // ClassCastException
        bd.test3();
        ((A)bd).test3(); //todo: а вот если метод не static, то обращение идет к методу ЭКЗЕМПЛЯРА, т.е. к инстансу класса B

        System.out.println("\n");
        // еще раз:
        A aaa = new A(2);
        A aab = new B();
        B bbb = new B();

        aaa.test1(); // работает A
        aab.test1(); // работает A!!!!, потому что тип объекта A
        bbb.test1(); // работает B
        ((B)aab).test1(); // работает B - здесь мы поменяли указанный тип на фактический!!!



    }
}
