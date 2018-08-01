package collectionsAndMaps.newProbes;

import java.util.Collections;
import java.util.Map;

public class SingletonMap {
    public static void main(String[] args) {
        Map map = Collections.singletonMap("key", "value");
        Map mapa = Collections.singletonMap(5, new Object());
        System.out.println(map);
        System.out.println(mapa);
    }
}
