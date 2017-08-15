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
            int count = (Integer)numberAndCount.get(i); // NullPointerException here ((NullPrimitiveAutoboxingKey))
            // -  здесь идет обращение к i-ой корзине мапы, которая пока что содержит null,
            // который может быть приведен к Integer, но не к int
            System.out.println(numberAndCount.put(i, count++));
            // вот еще пример:
            Integer a = null;
            int b = a; // NullPointerException here (NullPrimitiveAutoboxingKey)
        }
    }


}
