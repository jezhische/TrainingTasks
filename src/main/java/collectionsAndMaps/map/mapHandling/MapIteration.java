package collectionsAndMaps.map.mapHandling;

import java.util.Iterator;
import java.util.Map;

import static collectionsAndMaps.map.mapHandling.DataHashMap.data;


/**
 * Created by Ежище on 15.04.2017.
 */
public class MapIteration {
    public static Iterator<Map.Entry<Integer, String>> iter = data.entrySet().iterator();
    public static Iterator<Map.Entry<Integer, String>> iteriter = data.entrySet().iterator();
    public static void main(String[] args) {
        //TODO: NB: если итератор пройден, то второй раз его не пройдешь
        while (iter.hasNext()) {
            System.out.print(iter.next() + "; ");
        }
        System.out.println();
        //но если это новый итератор - то пожалуйста:
        while (iteriter.hasNext()) {
            Map.Entry<Integer, String> entry = iteriter.next();
            System.out.print(entry.getKey() + ":" + entry.getValue() + "; ");
        }
        System.out.println();
        //или если старый, но заново образованный:
        iter = data.entrySet().iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + "; ");
        }
        System.out.println();
        // или без итератора:
        for(Map.Entry<Integer, String> entry : data.entrySet()) {
            System.out.print(entry + "; ");
        }
    }
}
