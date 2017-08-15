package casting_see_inheritance;

/**
 * Created by Ежище on 11.08.2017.
 */
public class ClassCastingDistinct {
    protected void print() {
        System.out.println("ClassCastingDistinct print() here");
    }
    protected void print2() throws RuntimeException {
        System.out.println("ClassCastingDistinct print2() here");
    }

}
class Child extends ClassCastingDistinct {
    @Override
    public void print() {
        super.print();
    }

    @Override
    protected void print2() throws ArithmeticException { // а вот восходящее приведение к Exception невозможно
        System.out.println("Overrided ClassCastingDistinct print2() without super.print2() here");
    }
    public void print3() {
        super.print();
        System.out.println("Child only method print3() with super.print() here");
    }
}
class MainHere {
    public static void main(String[] args) {
        ClassCastingDistinct classCastingDistinct = new Child();
        classCastingDistinct.print();
        classCastingDistinct.print2();
//        classCastingDistinct.print3(); // так нельзя
        classCastingDistinct = (Child)classCastingDistinct; // так можно, но ничего не меняет
        ((Child)classCastingDistinct).print3(); // а вот так - годится
        Child child = (Child)classCastingDistinct;
        child.print3(); // и вот так - годится

        ClassCastingDistinct horror = new ClassCastingDistinct();
//        ((Child)horror).print3(); // нисходящее приведение дает ClassCastingDistinct
//        ClassCastingDistinct fobos = (Child)horror; // и так
//        Child chu = (Child)horror; // и так
    }
}
