package collectionsAndMaps.map.newM;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ForEachRemaining {
    public static LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

    static {
        map.put(0, "hhh");
        map.put(1, "jjj");
        map.put(2, "kkk");
    }

    public static void main(String[] args) {

        Iterator<Map.Entry<Integer, String>> iter = map.entrySet().iterator();

        for (int i = 0; iter.hasNext(); i++) {
            iter.next();
            if (i == 1)
//                iter.remove();
                iter.forEachRemaining(entry -> entry.setValue("yuyu"));
        }
        map.entrySet().forEach(System.out::println);
    }
}
