package trainingTest.differentGarbage;

/**
 * Created by Ежище on 09.07.2016.
 */
public class Test15GetterSetter {
    private int a;

    Test15GetterSetter(int a) {
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

    public Test15GetterSetter calc() {
        setA(a);
        a = getA()*2;
//        a *= 2;
        return this;
    }

    public static void main(String[] args) {
        Test15GetterSetter gs = new Test15GetterSetter (-10);
        gs.calc();
        System.out.println(gs.a);
    }
}
