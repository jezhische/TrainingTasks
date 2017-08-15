package inheritanceThisSuper.defaultConstructorTest;

/**
 * Created by WORK_x64 on 06.02.2017.
 */
public class Parent {
    public String name;
    public int a;


    public Parent() {
        System.out.println("Parent created");
    }
    public Parent(String name) {
        this.name = name;
        System.out.println("Parent: name is assigned: " + name);
    }
}
