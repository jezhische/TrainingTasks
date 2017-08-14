package inheritanceThisSuper.defaultConstructorTest;

/**
 * Created by WORK_x64 on 06.02.2017.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("\nParent():::");
        Parent parent = new Parent();
        System.out.println("\nParent(String name):::");
        Parent parentStringed = new Parent("namename");

        System.out.println("\nChild1(int a):::");
        Child1 child1 = new Child1(5);
        Parent p = (Parent) new Child1(8); // восходящее приведение не нужно, Child и так является Parent-ом. И методы
        // и поля, принадлежащие только чайлду (которых нет у парента) здесь будут недоступны
        // Т.е. вот так работать не будет:
//        p.print();
        // А вот так - будет:
        ((Child1)p).print();

        Parent par = new Parent("nock");
//        ((Child1)par).print(); // несмотря на то, что приведение не запрещается компилятором, при выполнении выскочит
        // ClassCastException


        System.out.println("\nChild1(String name):::");
        Child1 child1Stringed = new Child1("nmnm");
//        Child1 c = (Child1) new Parent(); // так нельзя
//        Child1 c = (Child1) new Parent("aharai"); // ClassCastException... Parent cannot be cast to...Child1
//        Parent c = (Child1) new Parent(); // Так тоже нельзя
//        Parent c = (Child1) new Parent("aharai"); // и так нельзя

        System.out.println("\nGrandchild1(int a):::");
        Grandchild1 grandchild1 = new Grandchild1(10);
        System.out.println("\nGrandchild1(String name):::");
        Grandchild1 grandchild1Stringed = new Grandchild1("thisthis");
        System.out.println("\nChild2():::");
        Child2 child2 = new Child2();
        System.out.println("\nGrandchild2(int a):::");
        Grandchild2 grandchild2 = new Grandchild2(10);
        System.out.println("\nGrandchild2(String name):::");
        Grandchild2 grandchild2Stringed = new Grandchild2("namenamename");
        System.out.println("\nChild3() (String name):::");
        Child3 child3 = new Child3("ohou");
        System.out.println("\nGrandchild3(String name):::");
        Grandchild3 grandchild3Stringed = new Grandchild3("crimson");
    }
}
