package genericClassesAndMethods.genericArrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by WORK_x64 on 28.12.2016.
 * http://ru.stackoverflow.com/questions/264255/generic-%D0%B8-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D1%8B
 */
public class GArr <T> {
    T arr [];
    void foo (int i) {
//        arr = new T [10];
        arr = (T[]) (new Object[i]);
    }
    T[] foof (int i) {
        return  (T[]) Array.newInstance(GArr.class, i);
    }

    public static void main(String[] args) {
        GArr <String> garr = new GArr<>();
        garr.foo(3);
//        garr.arr[0] = "fff";
        System.out.println(Arrays.deepToString(garr.arr));
       String [] s = garr.foof(3);
//       s[1] = "ggg";
//        System.out.println(Arrays.toString(s));
    }
}
