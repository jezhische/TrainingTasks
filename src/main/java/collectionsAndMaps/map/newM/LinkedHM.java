package collectionsAndMaps.map.newM;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHM<K, V> extends LinkedHashMap<K, V> {

    private int initialCapacity;

    public LinkedHM(int initialCapacity) {
        super(initialCapacity, 1f, true);
        this.initialCapacity = initialCapacity;
    }
    public LinkedHM(int initialCapacity, Map<K, V> map) {
        super(initialCapacity, 1f, true);
        this.initialCapacity = initialCapacity;
        putAll(map);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > initialCapacity;
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(5, 0.9f, true);
        for (int i = 98; i < 102; i++) {
            map.put(i, String.valueOf((char) i));
        }
        System.out.print("map 1: ");
        map.forEach((integer, string) -> System.out.printf("%d:%s, ", integer, string));
        map.get(100);
        System.out.print("\nmap 2 after get(100): ");
        map.forEach((integer, string) -> System.out.printf("%d:%s, ", integer, string));
        map.get(98);
        System.out.print("\nmap 3 after get(98): ");
        map.forEach((integer, string) -> System.out.printf("%d:%s, ", integer, string));


        LinkedHM<Integer, String> mapa = new LinkedHM<>(3, map);
        System.out.print("\nmapa 1: ");
        mapa.forEach((integer, string) -> System.out.printf("%d:%s, ", integer, string));
        mapa.put(102, "uu");
        System.out.print("\nmapa 2 after put(102, \"uu\"): ");
        mapa.forEach((integer, string) -> System.out.printf("%d:%s, ", integer, string));
        mapa.get(100);
        System.out.print("\nmapa 3 after get(100): ");
        mapa.forEach((integer, string) -> System.out.printf("%d:%s, ", integer, string));
    }
}
