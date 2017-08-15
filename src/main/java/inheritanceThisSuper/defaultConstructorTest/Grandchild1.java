package inheritanceThisSuper.defaultConstructorTest;

/**
 * Created by WORK_x64 on 06.02.2017.
 */
public class Grandchild1 extends Child1 {
    public Grandchild1(int a) {
        super(a); // только так, без этого конструктора и без этой строчки пишет "нет нужного конструктора" - поскольку
        // конструктора по умолчанию в классе Child1 у меня действительно нет, и непонятно, как так.
    }
//    public Grandchild1(){} // так не получается - "нет нужного конструктора"
public Grandchild1(String name) {
    super(name);
    System.out.println("Grandchild1 created with (String name) and super(name): " + name);
}
}
