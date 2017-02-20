package collectionsAndMaps.map;

import java.util.*;

/**
 * Created by Ежище on 17.02.2017.
 */
public class LinkedHMSimpleLRU<K, V> extends LinkedHashMap<K, V> {

    private int capasity;

    public LinkedHMSimpleLRU(int capasity) {
        super(capasity, 1f, true);
        this.capasity = capasity;
    }
/* Этот метод д.б. переопределен, поскольку когда он не возвращает true (а в своем родительском виде он никогда не
* возвращает true), он ничего не делает **/
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return /*this.*/size() > capasity;
    }

    public static void main(String[] args) {
        LinkedHMSimpleLRU<String, Integer> lru = new LinkedHMSimpleLRU<>(3);
        for (int i = 0; i < 4; i++)
            System.out.print((i + 100) + ": " + (char) (100 + i) + ", ");
        System.out.println();
        for (int i = 0; i < 4; i++)
            lru.put(String.valueOf((char) (100 + i)), 100 + i);
        /* вывод через итератор: **/
        for (Map.Entry<String, Integer> entry: lru.entrySet())
            System.out.print(entry.getValue() + ": " + entry.getKey() + ", ");
        System.out.println();
        /* вывод через скрытый итератор: **/
        lru.forEach((s, i) -> System.out.print(i + ": " + s + ", "));
    }
}
