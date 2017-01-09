package javaFromTkach.collections.map_2;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Ежище on 08.01.2017.
 */
public class LinkedHashMapProbe {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(5, "a");
        hashMap.put(4, "b");
        hashMap.put(3, "c");
        hashMap.put(2, "d");
        hashMap.put(1, "e");
        System.out.println("hashMap = " + hashMap);
       // потому что:
        Integer a = 1, b = 2;
        System.out.printf("         1.hashCode = %d, 2.hashCode = %d etc\n", a.hashCode(), b.hashCode());
        // и потом выстроился порядок хэш-кодов по возрастанию. Как сохранить порядок вставки:
        HashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(5, "a");
        linkedHashMap.put(4, "b");
        linkedHashMap.put(3, "c");
        linkedHashMap.put(2, "d");
        linkedHashMap.put(1, "e");
        System.out.println("linkedHashMap = " + linkedHashMap);

        HashMap<Integer, String> linkedAccessedHashMap = new LinkedHashMap<>(5, 1f,
                true); // accessOrder - элементы расставляются в таком порядке, что первым идет
        // наиболее ДАВНО использованный, а последним - самый недавно используемый. Т.е., можно проследить ниже -
        // элементы выстраиваются в том порядке, в каком их вызывали.
        // "Использовать, получить доступ" - это только методы get() или put(), итератор не считается.
        linkedAccessedHashMap.put(5, "a");
        linkedAccessedHashMap.put(4, "b");
        linkedAccessedHashMap.put(3, "c");
        linkedAccessedHashMap.put(2, "d");
        linkedAccessedHashMap.put(1, "e");
        linkedAccessedHashMap.get(3);
        linkedAccessedHashMap.get(5);
        linkedAccessedHashMap.get(1);
        linkedAccessedHashMap.get(3);
        linkedAccessedHashMap.put(1, "e");
        System.out.println("linkedAccessedHashMap = " + linkedAccessedHashMap);
    }
}
