package collectionsAndMaps.map;

import java.util.*;

/**
 * Created by Ежище on 17.02.2017.
 */
public class LinkedHMSimpleLRU<K, V> extends LinkedHashMap<K, V> {

    private int capasity;

// accessOrder: false (default) - порядок согласно порядку вставки; true - порядок согласно частоте доступа (от меньшей к большей)
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
        System.out.println("\n******");

        // положим в мапу элемент, который в ней уже есть
        lru.put("f", 102);
        lru.forEach((key, value) -> System.out.print(value + ": " + key + ", "));
        System.out.println();
        // итерация в обратном порядке:
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(lru.entrySet());
        for (int i = entries.size() - 1; i >= 0 ; i--) {
            Map.Entry<String, Integer> entry = entries.get(i);
            System.out.print(entry.getValue() + ": " + entry.getKey() + ", ");
        }
        System.out.println();
        // еще вариант итерации в обратном порядке:
        Collections.reverse(entries);
        entries.forEach(e -> System.out.print(e.getValue() + ": " + e.getKey() + ", "));
    }
}
