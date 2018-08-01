package garbage.constructor.newProbe;

public class Class2 extends Class1 {
    Class2(double d) {              // 1
        this((int) d);
        System.out.println("Class2(double)");
    }

    Class2(int i) {                 // 2
        super(i); // NB: вот без этого обращения к конструктору супер-класса выскочит ошибка компиляции:
//        "There is no default constructor available in "garbage.constructor.newProbe.Class1""
        System.out.println("Class2(int)");
    }

    public static void main(String[] args) {
        new Class2(0.0);
    }
}
class Class1 {
    Class1(int i) {
        System.out.println("Class1(int)");
    }
}