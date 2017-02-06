package inheritanceThisSuper.defaultConstructorTest;

/**
 * Created by WORK_x64 on 06.02.2017.
 */
public class Grandchild2 extends Child2 {
    public Grandchild2(int a) {
        this.a = a;
        System.out.println("Grandchild2 created with (int a)");
    }
    public Grandchild2(String name) {
//        super(name); // так не получается - у Child2 нет такого конструктора
//        super().super(name); // и так тоже нельзя
        this.name = name;
    }
}
