package collectionsAndMaps.map.newM;

import java.util.HashMap;
import java.util.Map;

public class HashMapTesst {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(1, 2);
        map.put(1, 2);
        System.out.println(map.size());
        map.forEach((key, value) -> System.out.println(key + ": " + value + ";"));
    }
}
