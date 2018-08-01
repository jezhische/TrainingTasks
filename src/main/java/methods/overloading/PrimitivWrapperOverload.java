package methods.overloading;

public class PrimitivWrapperOverload {
    static void m(int i) {
        System.out.println("int ok");
    }

    static void m(Integer i) {
        System.out.println("Integer ok");
    }

    //    А вот с vararg такое не проходит!!!!:
    static void mm(int... i) {
        System.out.println("int ok");
    }

    static void mm(Integer... i) {
        System.out.println("Integer ok");
    }

    public static void main(String[] args) {
        m(5); // int ok
//        mm(5, 2); // Ambiguous method call!!!!!!!
    }
}
