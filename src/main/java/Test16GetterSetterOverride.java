/**
 * Created by Ежище on 09.07.2016.
 */
public class Test16GetterSetterOverride extends Test15GetterSetter {

    Test16GetterSetterOverride(int a) {
        super(a);
//        setA(a);
//        this.a = getA();
    }
    @Override
    public Test15GetterSetter calc () {
//        super.a = a;
//        super.calc();
//        setA(getA()-3);
        for (int i = 0; i < 3; i++) {
            super.calc();
            setA(getA()-3);
        }
        return this;
    }

    public static void main(String[] args) {
        Test16GetterSetterOverride test1 = new Test16GetterSetterOverride (-5);
        test1.calc();
        System.out.println("test1=" + test1.getA());
        Test16GetterSetterOverride test2 = new Test16GetterSetterOverride (5);
        test2.calc();
        System.out.println("test2=" + test2.getA());

    }
}
