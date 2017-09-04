package inheritanceThisSuper.newConstructorSimple;

import java.io.IOException;

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

    A test3() throws Exception { // можно было бы возвращаемый тип поставить Object, тогда в классе B и здесь в return
        // вообще любой тип можно поставить
        System.out.println("A.test3");
        try {int a = 1 / 0;
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
        return new A(5); // можно и так: return new B(); - поскольку тип B является также своим родителем
    }

    Object polymorph()  {
        return "ooo!";
    }

    protected int polymorph2() {
        return 2; // 2L не годится
    }



    @Override
    public String toString() {
        return "class name: " + this.getClass().getSimpleName() + ", superclass name: " +
                this.getClass().getSuperclass().getSimpleName();
    }
}
