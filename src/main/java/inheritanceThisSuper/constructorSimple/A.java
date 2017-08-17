package inheritanceThisSuper.constructorSimple;

public class A {
    private int i;

    public A(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "class name: " + this.getClass().getSimpleName() + ", superclass name: " +
                this.getClass().getSuperclass().getSimpleName();
    }
}
