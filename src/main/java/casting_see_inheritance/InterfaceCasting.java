package casting_see_inheritance;

/**
 * Created by Ежище on 11.08.2017.
 */
public class InterfaceCasting implements Fox {
    @Override
    public void print() {
        System.out.println("Fox method print() implemented");
    }

    @Override
    public void print(int i) {
        System.out.printf("Fox method print(int i) with i = %d implemented\n", i);
    }

    public void print(String name) {
        System.out.printf("Overrided method print(String name), belonging to InterfaceCasting class only, " +
                "with name = %s implemented\n", name);
    }
}
interface Fox {
    void print();
    void print(int i);
    static void print(String text) {
        System.out.println("Fox static void print(String text) here, " + text);
    }
}
class Main {
    public static void main(String[] args) {
        Fox fox = new InterfaceCasting();
        fox.print();
        fox.print(5);
        Fox.print("ooh!");
//        fox.print("bbb"); // а вот так - нельзя! метод класса, если его нет в интерфейсе, недоступен
//        ((Fox)fox).print("ooh!"); // и так нельзя
        Fox slyFox = (Fox)fox;
//        slyFox.print("ooh!"); // и так нельзя, в отличие от ситуации наследования

        fox = (InterfaceCasting) fox; // это возможно, но ничего не меняет
        ((InterfaceCasting) fox).print("hohoho"); // а вот так - работает!
    }
}
