package inheritanceThisSuper.defaultConstructorTest;

/**
 * Created by WORK_x64 on 06.02.2017.
 */
public class Grandchild3 extends Child3 {
    public Grandchild3(String name) {
        super(name);
        System.out.println("Grandchild3 created with (String name): " + name);
    }
}
