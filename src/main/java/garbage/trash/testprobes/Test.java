package garbage.trash.testprobes;

import java.util.Map;

/**
 * Created by WORK_x64 on 13.01.2017.
 */
public class Test {
    public static void main(String[] args) {
        Map map = new TestMap();
        System.out.println(map.keySet());
        for (Object o : map.keySet()) {
            System.out.println(o);
        }
//        Object a = new Object();
//        Object b = new Object();
//        if (a.equals(b))
//            System.out.println("yes");
    }
}
//    будет NullPointerException. цикл развернется в такую конструкцию:
//
//        for(Iterator<object> i = map.keySet().iterator(); i.hasNext(); ) {
//        String item = i.next();
//        System.out.println(item);
//        }