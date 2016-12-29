package genericClassesAndMethods.genericArrays;

import javax.swing.*;
import java.lang.reflect.Array;

/**
 * Created by WORK_x64 on 29.12.2016.
 * http://javatalks.ru/topics/27209
 */
public class GenericsTest <T> {
    private T[] data;

    @SuppressWarnings("unchecked")
    public GenericsTest(Class<T> clazz){
        data = (T[]) Array.newInstance(clazz, 10);
    }

    public Class<?> getDataClass(){
        return data.getClass();
    }

    public static void main(String[] args) {
        GenericsTest<String> gt1 = new GenericsTest<String>(String.class);
        GenericsTest<Integer> gt2 = new GenericsTest<Integer>(Integer.class);
        GenericsTest<JComponent> gt3 = new GenericsTest<JComponent>(JComponent.class);
        System.out.println("1: "+gt1.getDataClass().getName());
        System.out.println("2: "+gt2.getDataClass().getName());
        System.out.println("3: "+gt3.getDataClass().getName());

        gt1.data[0] = "bbd";
        String [] s = new GenericsTest<String>(String.class).data;
        s[0] = "23";
        System.out.println(s[0]);
        System.out.println(gt1.data[0]);
    }
}
