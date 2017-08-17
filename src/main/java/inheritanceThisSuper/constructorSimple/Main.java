package inheritanceThisSuper.constructorSimple;

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
    }
}
