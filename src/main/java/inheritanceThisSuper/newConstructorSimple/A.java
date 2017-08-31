package inheritanceThisSuper.newConstructorSimple;

public class A {
    private int i;

    public A(int i) {
        this.i = i;
    }

     static void test1() {
        System.out.println("A.test1");
    }
    static void test2() {
        test1();
    }

    void test3() {
        System.out.println("A.test3");
    }

    @Override
    public String toString() {
        return "class name: " + this.getClass().getSimpleName() + ", superclass name: " +
                this.getClass().getSuperclass().getSimpleName();
    }
}
