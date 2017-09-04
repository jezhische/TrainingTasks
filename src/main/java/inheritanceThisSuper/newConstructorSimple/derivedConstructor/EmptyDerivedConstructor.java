package inheritanceThisSuper.newConstructorSimple.derivedConstructor;

public class EmptyDerivedConstructor {

}
class A {
    String s;

    public A(String s) {
        this.s = s;
    }
}
class B extends A {
    public B() {
        super("hou!");
    }
}
