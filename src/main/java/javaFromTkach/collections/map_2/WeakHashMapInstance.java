package javaFromTkach.collections.map_2;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Ежище on 08.01.2017.
 */
public class WeakHashMapInstance {
    // имеет смысл, когда нужно быстро удалить объект из мапы, или чтобы он сам удалился при каком-либо фэйле...
    // кажется, также просто при переполнении памяти gc почистит старые ключи, даже если они не null (???),
    // так что можно использовать WeakHashMap как хранилище информации, к которой можно постоянно обращаться, и
    // которое будет следить за своим переполнением само...
    public static void main(String[] args) {
        class Data {}
        Data data = new Data();
        Map<Data, String> map = new WeakHashMap<>();
        map.put(data, "information");
        data = null; // убрали на него ссылку - делаем доступным для gc
        System.gc();
        for (int i = 0; i < 10000; i++) { // for (Map.Entry<Data, String> entry: map.entrySet())
//            System.out.println(entry);
            if (map.isEmpty()) {
                System.out.println("i = " + i + "; Empty!"); // gc не вызывается сразу по приказу в java, для
                // этого такой большой цикл.
                break;
            }
        }
    }
}
