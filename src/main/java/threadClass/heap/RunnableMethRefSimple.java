package threadClass.heap;

import java.util.function.Predicate;

/**
 * Created by WORK_x64 on 09.02.2017.
 */
public class RunnableMethRefSimple {

    private boolean bool(String s) {
        return s == "string";
    }

    public Integer getInteger(int a) {
        return new Integer(a);
    }
    static int s = 0;

    Predicate<String> stringPredicate = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s == "string";
        }
    };
    Predicate<String> st2 = (s) -> s == "string";
    Predicate<String> st3 = new A()::bool;
    Predicate<String> st4 = this::bool;

     void go() {
        System.out.println("go!");
    }

    public static void main(String[] args) {
        RunnableMethRefSimple meth = new RunnableMethRefSimple();
        Integer i = meth.getInteger(5);
        String sss = "string";
        String ssss = new String("string");
        System.out.println(meth.stringPredicate.test(ssss.intern()));
        System.out.println(meth.st3.test("string"));

        new Thread(() -> System.out.println("ho ho!")).start();
        new Thread(new RunnableMethRefSimple()::go).start();

    }
}
class A {
    public boolean bool(String s) {
        return s == "string";
    }
}
