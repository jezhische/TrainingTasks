package collectionsAndMaps.garbage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ежище on 10.12.2016.
 */
public class MapProbe1 {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++)
            map.put(i, String.valueOf(String.valueOf(Character.toChars(i + 100)) +
                    String.valueOf(Character.toChars(i + 105)) +
                    String.valueOf(Character.toChars(i + 110))));
        for (Map.Entry<Integer, String> item: map.entrySet()) {
            System.out.printf("map key: %d, map value: %s\n", item.getKey(), item.getValue());
        }
        String s = ";skcnchyysb";
        System.out.println(s.charAt(6));
    }
}
