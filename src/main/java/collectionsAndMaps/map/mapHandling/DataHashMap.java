package collectionsAndMaps.map.mapHandling;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Ежище on 15.04.2017.
 */
public class DataHashMap {
    public static Map<Integer, String> data = new HashMap<>();
    private static Random rand = new Random();
    private static String getRandomString() {
        StringBuilder sbuilder = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            sbuilder.append((char)(70 + rand.nextInt(40)));
        }
        return sbuilder.toString();
    }
    static {
        for (int i = 0; i < 10; i++) {
             data.put(i, getRandomString());

        }
    }

    public static void main(String[] args) {
    }
}
