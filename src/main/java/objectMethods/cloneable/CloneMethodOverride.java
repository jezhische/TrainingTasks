package objectMethods.cloneable;

/**
 * Created by Ежище on 26.12.2016.
 */
public class CloneMethodOverride implements Cloneable {
    Integer i;

    @Override
    public CloneMethodOverride clone() throws CloneNotSupportedException {
        CloneMethodOverride clo = (CloneMethodOverride) super.clone();
        clo.i = i;
        return clo;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneMethodOverride test = new CloneMethodOverride();
        System.out.println(test.i);
        CloneMethodOverride bTest = test.clone();
        CloneMethodOverride cTest = test;
        test.i = 5;
        System.out.printf("test.i = %s, bTest.i = %s, cTest.i = %s\n", test.i, bTest.i, cTest.i);
        bTest.i = 10;
        System.out.printf("test.i = %s, bTest.i = %s, cTest.i = %s\n", test.i, bTest.i, cTest.i);
        cTest.i = 15;
        System.out.printf("test.i = %s, bTest.i = %s, cTest.i = %s\n", test.i, bTest.i, cTest.i);
    }
}
