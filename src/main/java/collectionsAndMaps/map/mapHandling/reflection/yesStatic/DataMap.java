package collectionsAndMaps.map.mapHandling.reflection.yesStatic;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Ежище on 15.04.2017.
 */
public class DataMap {
    private static final Map<Integer, String> data = new HashMap<>();
    private static Random rand  = new Random();

    private static String getRandomString() {
        StringBuilder sbuilder = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            sbuilder.append((char) (70 + rand.nextInt(40)));
        }
        return sbuilder.toString();
    }

    static {
        for (int i = 0; i < 10; i++) {
            data.put(i, getRandomString());
        }
    }

    // Constructor:
    private DataMap() {}

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
