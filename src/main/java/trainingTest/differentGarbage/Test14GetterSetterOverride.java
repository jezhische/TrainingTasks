package trainingTest.differentGarbage;

/**
 * Created by Ежище on 09.07.2016.
 */
public class Test14GetterSetterOverride extends Test13GetterSetter {

    Test14GetterSetterOverride(int a) {
        super(a);
        setA(a);
//        this.a = getA();
    }
    @Override
    public Test13GetterSetter calc () {
//        super.a = a;

        for (int i = 0; i < 3; i++) {
//            super.calc();
            setA(getA()-3);
        }
        return this;
    }

    public static void main(String[] args) {
        Test14GetterSetterOverride test = new Test14GetterSetterOverride (-5);
        test.calc();
        System.out.println(test.getA());

    }
}
