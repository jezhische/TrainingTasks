package garbage.trash.nullProbes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WORK_x64 on 12.01.2017.
 * http://info.javarush.ru/translation/2014/12/13/9-%D0%B2%D0%B5%D1%89%D0%B5%D0%B9-%D0%BE-NULL-%D0%B2-Java-.html
 */
public class NullPrimitiveAutoboxingKey {
    public static void main(String args[]) throws InterruptedException {
        Map numberAndCount = new HashMap<>();
        int[] numbers = {3, 5, 7,9, 11, 13, 17, 19, 2, 3, 5, 33, 12, 5};
        for(int i : numbers){
            int count = (int)numberAndCount.get(i); // NullPointerException here
//            int count = numbers[i];
//            int count = 0;
            System.out.println(numberAndCount.put(i, count++));
        }
    }


}
