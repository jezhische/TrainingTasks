package trainingTest;

/**
 * Created by Ежище on 09.07.2016.
 */
public class Test13GetterSetter {
    private int a;

    Test13GetterSetter(int a) {
        this.a = a;
    }

    public void setA(int a) {
        if (a > 0)
            this.a = a;
        else
            System.out.println("Сработал сеттер");
    }

    public int getA() {
        return a;
    }

    public Test13GetterSetter calc() {
        a *= 2;
        return this;
    }
}
