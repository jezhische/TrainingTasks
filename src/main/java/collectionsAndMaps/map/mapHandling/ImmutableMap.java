package collectionsAndMaps.map.mapHandling;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static collectionsAndMaps.map.mapHandling.DataHashMap.data;

/**
 * Created by Ежище on 15.04.2017.
 */
public class ImmutableMap {
    // http://stackoverflow.com/questions/22636575/unmodifiablemap-java-collections-vs-immutablemap-google
    // private static final  - уже не обязательно (??)
    private static final Map<Integer, String> immutableData =
            Collections.unmodifiableMap(new LinkedHashMap<Integer, String>(data));

    public static void main(String[] args) {
        System.out.println(immutableData.get(3));
        try {
            immutableData.put(5, "a");
            immutableData.clear();
        } catch (UnsupportedOperationException ex) {
            ex.printStackTrace();
        }
        Iterator<Map.Entry<Integer, String>> iter = data.entrySet().iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + "; ");
        }
        System.out.println();
    }

}
