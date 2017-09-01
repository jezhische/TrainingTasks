package garbage.inheritanceNew;

/**
 * Created by WORK_x64 on 01.09.2017.
 */
public class StaticProbe {
    public static void main(String[] args) {
//        B b = new B();
//        ((A)new B()).print();
//        ((A)new B()).printS();
//        new B().printS();
        System.out.println(A.i);
        System.out.println(B.i);
        B b = new B();
        A a = new A();
        System.out.println(A.i);
        System.out.println(B.i);

//        System.out.println(Integer.toString(-0b10101>>>1));
//        System.out.println(Integer.toString(-0b1010<<1));
//        System.out.println(Integer.toString(~ -0b1010));
//        System.out.println();
//        System.out.println(Integer.toString(0b1101 & 0b100 ));
//        System.out.println(Integer.toString(0b1101 | 0b100));
//        System.out.println(true || false);

    }

}
class A {
    static int i;
    static {i = 7;}

    protected void print() throws RuntimeException {
        System.out.println("this is non-static A.print()");
    }
    static void printS() {
        System.out.println("this is STATIC A.printS()");

    }

}
class B extends A {
    static {i = 3;}
    @Override
    public final void print() throws ArithmeticException {
        System.out.println("this is non-static B.print()");
    }
    static void printS() {
        System.out.println("this is STATIC B.printS()");

    }
}
