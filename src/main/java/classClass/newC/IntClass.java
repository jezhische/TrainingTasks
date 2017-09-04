package classClass.newC;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class IntClass {
    public static void main(String[] args) {
        System.out.println(int.class);
        System.out.println(double.class);
        System.out.println("".getClass());
        Class inti = int.class;
        Method[] meti =  inti.getDeclaredMethods();
        System.out.println(Arrays.toString(meti));
        Constructor[] consti = inti.getDeclaredConstructors();
        System.out.println(Arrays.toString(consti));
    }
}
