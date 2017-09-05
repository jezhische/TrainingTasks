package genericClassesAndMethods.newG.genericArrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by WORK_x64 on 29.12.2016.
 * http://javatalks.ru/topics/27209
 */

public class GenericArray <T> {

    Class<?> clazz;
    public GenericArray (Class<?> clazz) {
        this.clazz = clazz;
    }
    @SuppressWarnings ("unchecked")
    T[] arrT (int length) {
       return (T[]) Array.newInstance(clazz, length);
  }

    public static void main(String[] args) {
//        Object [] s = new GenericArray(Object.class).arrT(5); // а вот так примет любой объект.
        String [] s = new GenericArray<String>(String.class).arrT(5);
        s[0] = "45";
        s[2] = "rrr";
        System.out.println("String [] s = " + Arrays.deepToString(s));

        Integer [] i = new GenericArray<Integer>(Integer.class).arrT(25);
        i[3] = 78;
        i[18] = 236;
        System.out.println("Integer [] i = " + Arrays.toString(i));
    }
}
