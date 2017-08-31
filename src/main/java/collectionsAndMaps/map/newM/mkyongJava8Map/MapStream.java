package collectionsAndMaps.map.newM.mkyongJava8Map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/** https://www.mkyong.com/java8/java-8-filter-a-map-examples/ */

public class MapStream {
    private static final Map<Integer, String> A_MAP_EXAMPLE = new HashMap<>();
    static {
        A_MAP_EXAMPLE.put(0, "hgghhg");
        A_MAP_EXAMPLE.put(1, "erty");
        A_MAP_EXAMPLE.put(2, "something");
        A_MAP_EXAMPLE.put(3, "vcbbv");
        A_MAP_EXAMPLE.put(4, "something");

    }

    public static void main(String[] args) {
        // todo: to filter a Map
        // before java8
        String result = "";
        for (Map.Entry<Integer, String> entry : A_MAP_EXAMPLE.entrySet()) {
            if("something".equals(entry.getValue())){
                result = entry.getValue();
                System.out.println(entry);
            }
        }
        // java8
        //Map -> Stream -> Filter -> String
        result = A_MAP_EXAMPLE.entrySet().stream()
                .filter(map -> "something".equals(map.getValue()))
                .map(map->map.getValue())
                .collect(Collectors.joining());
        System.out.println(result);

        //Map -> Stream -> Filter -> MAP
        Map<Integer, String> collect = A_MAP_EXAMPLE.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

    }
}
