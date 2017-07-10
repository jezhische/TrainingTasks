package collectionsAndMaps.map.mapHandling.reflection.nonStatic;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Ежище on 15.04.2017.
 */
public class DataMap {
    private final Map<Integer, String> data;
    private Random rand;

    private String getRandomString() {
        StringBuilder sbuilder = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            sbuilder.append((char) (70 + rand.nextInt(40)));
        }
        return sbuilder.toString();
    }

    // Constructor:
    private DataMap() {
        data = new HashMap<>();
        rand  = new Random();
        for (int i = 0; i < 10; i++) {
            data.put(i, getRandomString());
        }
    }

    private static final DataMap INSTANCE = new DataMap();
    public static DataMap getInstance() {
        return INSTANCE;
    }

    public void printData() {
        for(Map.Entry<Integer, String> entry : data.entrySet()) {
            System.out.print(entry + "; ");
        }
    }
}
