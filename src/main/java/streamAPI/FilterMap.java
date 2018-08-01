package streamAPI;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by WORK_x64 on 07.08.2017.
 */
public class FilterMap {

    // это метод, который заставит TreeMap хоть как-то отсортироваться по values, хотя это и противоречит ее
    // внутренней сути - см. внизу
    private static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    public static void main(String[] args) {

        Stream<Sample> sampleStream = Stream.of(new Sample("Hoo", 1), new Sample("Hao", 2),
                new Sample("Hoa", 3), new Sample("Hoop", 4), new Sample("AHoo", 5),
                new Sample("Hooda", 6), new Sample("Hoertryo", 7));

        HashMap<String, Integer> beforeMap = // NB: метод toMap возвращает Map, а не HashMap!
                // либо используем ссылку на метод класса:
                new HashMap<>(sampleStream.collect(Collectors.toMap(Sample::getKey, Sample::getValue)));
        // либо обращаемся к объекту и добываем из него значение с помощью соотв. метода:
//        Collectors.toMap(s -> s.getKey(), s -> s.getValue())
        // toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
        // Function принимает T, возвращает K; и принимает T, возвращает U

        beforeMap.forEach((k, v) -> System.out.println(k + ": " + v));

//        // Классика:
//        Set<Map.Entry<String, Integer>> set = beforeMap.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
//        String test;
//        while (iterator.hasNext()) {
//            test = iterator.next().getKey();
//            if (test.contains("a") || test.contains("A"))
//                iterator.remove();
//        }
//        System.out.println();
//        beforeMap.forEach((k, v) -> System.out.println(k + ": " + v));

//        // Иной вариант:
//        System.out.println();
//        ArrayList<String> transitional = new ArrayList<>();
//        beforeMap.forEach((k, v) -> { if (k.contains("a") || k.contains("A")) transitional.add(k);});
//        transitional.stream().forEach(beforeMap::remove);
//        beforeMap.forEach((k, v) -> System.out.println(k + ": " + v));

//       // здесь тоже ConcurrentModificationException:
//        System.out.println();
//        Set<Map.Entry<String, Integer>> set = beforeMap.entrySet();
//        set.forEach(e -> {if (e.getKey().contains("a") || e.getKey().contains("A")) beforeMap.remove(e.getKey());});
//        beforeMap.forEach((k, v) -> System.out.println(k + ": " + v));
//
//        // Еще вариант:
//        System.out.println();
//        ArrayList<String> temporal = beforeMap.entrySet().stream().collect(() -> new ArrayList<String>(),
//                (list, entry) -> {
//            String s = entry.getKey();
//            if (s.contains("a") || s.contains("A")) list.add(s);},
//                (list1, list2) -> list1.addAll(list2));
//        temporal.forEach(beforeMap::remove);
//        beforeMap.forEach((k, v) -> System.out.println(k + ": " + v));

        // Иная запись этого варианта:
        // Еще вариант:
        System.out.println();
        beforeMap.entrySet().stream().collect(ArrayList::new,
                (list, entry) -> {
                    String s = entry.getKey();
                    if (s.contains("a") || s.contains("A")) list.add(s);},
                ArrayList::addAll).forEach(beforeMap::remove);
        beforeMap.forEach((k, v) -> System.out.println(k + ": " + v));


        // check for TreeMap work:
        System.out.println("---------------------------------------------------------");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("yo", 5);
        treeMap.put("au", 25);
        treeMap.put("au", 25);
        treeMap.forEach((string, integer) -> System.out.println(">>" + string + ": " + integer));

// попробуем заставить TreeMap сортировать по значению, а не по ключу:
        // "Generally speaking, the need to sort a map's entries by its values is atypical."
        // TreeMap сопротивляется тому, чтобы быть сортированной по value.
        SortedSet<Map.Entry<String, Integer>> sortedSet = FilterMap.entriesSortedByValues(treeMap);
        sortedSet.forEach(System.out::println);

        // one more time - describing of LinkedHashMap sorting:
        LinkedHashMap<String, String> favoriteRockBandOptions = new LinkedHashMap<>();
            favoriteRockBandOptions.put("Beatles", "B");
            favoriteRockBandOptions.put("Rolling Stones", "RS");
            favoriteRockBandOptions.put("Pink Floyd", "PF");
            favoriteRockBandOptions.put("Jethro Tall", "JT");
        // Попробуем применить снова эту же перегрузку метода collect():
// <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
//        supplier: создает объект коллекции типа R
//        accumulator: добавляет в коллекцию R элемент T
//        combiner: бинарная функция, которая объединяет два объекта (добавляет в первую коллекцию R вторую коллекцию R)
// В нашем случае этот метод должен выглядеть так:
//    LinkedHashMap<String, String> collect(Supplier<LinkedHashMap<String, String>>,
//                                          BiConsumer<LinkedHashMap<String, String>, ? super Entry<String, String>>,
//                                          BiConsumer<LinkedHashMap<String, String>, LinkedHashMap<String, String>>)
        favoriteRockBandOptions = favoriteRockBandOptions.entrySet().stream()
// здесь создаем новый Comparator, поскольку мы должны указать, как мы сравниваем объекты Map.Entry - по key или по value:
                .sorted(Comparator.comparing(Map.Entry::getValue)) // или: (o1, o2) -> o1.getValue().compareTo(o2.getValue())
                .collect(LinkedHashMap<String, String>::new, //   или: () -> new LinkedHashMap<String, String>()
                        (mapa, entry) -> mapa.put(entry.getKey(), entry.getValue()),
                        Map::putAll); // или:  (map, mapa) -> map.putAll(mapa)
    }
}

class Sample {
    private final String key;
    private final Integer value;

    Sample(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}
