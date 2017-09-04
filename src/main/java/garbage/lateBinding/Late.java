package garbage.lateBinding;

import java.io.IOException;

/**
 * Created by WORK_x64 on 04.09.2017.
 */
public class Late {
    static void print(A a) {
        System.out.println(a);
    }

    public static void main(String[] args) throws Exception {
        print(new A());
        print(new B());
        print((A) new B());
        A ab = new B();
        ab.method(5);
        print(ab);
        System.out.println(ab.getClass());
        System.out.println(ab instanceof B);
    }

}
class A {
    protected A method(int i) throws Exception {
        System.out.println("это A");
        return new A();
    }
    @Override
    public String toString()  {
        return "это " + this.getClass().getSimpleName();
    }
}
class B extends A {
    @Override
    public A method(int i) throws Exception {
        System.out.println("это B");
        return new A();
    }
}