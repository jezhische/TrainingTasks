package casting_see_inheritance;

/**
 * Created by Ежище on 11.08.2017.
 *
 * http://www.quizful.net/post/java-fields-initialization
 */
public class InheritanceInitOrder {
    static class A {
        String a;
        A() {
            a = "a";
            System.out.println("a initialized");
            System.out.println("b=" + ((B)this).b); // вообще не пониамаю, как автору этого класса удалось создать
            // нисходящее приведение
        }
    }

    static class B extends A {
        String b;
        B() {
            b = "b";
            System.out.println("b initialized");
            System.out.println("b=" + b);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new B();
    }
}
