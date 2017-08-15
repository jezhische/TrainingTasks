package javaFromTkach.collections.map_2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Ежище on 08.01.2017.
 */
public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {
    // LRU - List of Recently Used
    private int capacity;
    public SimpleLRUCache(int capacity) {
        super(capacity +1, 1.1f, true); // вообще-то, и так работает: super(capacity, 1f, true);
        // и даже так: (capacity, 0.5f, true); - поскольку в переопределенном методе removeEldestEntry срабатывает
        // remove, как только size() > capacity; остальное нужно для гарантии, что размер мапы не будет дергатьсяю
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//        return super.removeEldestEntry(eldest);
        return size() > capacity; // в super случае этот метод просто возвращает false, и при этом ничего не делает;
        // но если заставиьь его вернуть true, как в этом случае переопределения, он удалит eldest элементы.
    }

    public static void main(String[] args) {
        SimpleLRUCache<Integer, Integer> simple = new SimpleLRUCache<>(5);
        for (int i = 4; i >= 0; i--)
            simple.put(i, i);
        System.out.println(simple);
        simple.get(4);
        simple.put(5, 5);
        simple.put(6, 6);
        System.out.println(simple);
    }
}
