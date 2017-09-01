package garbage.arrays;

import java.util.Arrays;

public class InheritanceInArray {

    public static <T> void print(T[] arr) {
        for (T t : arr) {
            System.out.print(t + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Кстати, array при такой инициализации представляет собой, на самом деле, локальный в данном случае класс
        // (или внутренний (inner класс-член), если он в основном классе расположен, или вложенный, если static:
        A[] a = {new A(), new B(), (A) new B()/*, ((B) new A())*/}; // т.е. наследники прекрасно ложатся в
        // родительский array
        print(a);

        A ab = new B();
        Object obj = new B();
        B[] b = {(B) (A) new B(), (B) ab, (B) obj, new B(), new B()};
        print(b);
    }
}
class A {}
class B extends A {}