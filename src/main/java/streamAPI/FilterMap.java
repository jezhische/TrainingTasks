package streamAPI;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by WORK_x64 on 07.08.2017.
 */
public class FilterMap {
    public static void main(String[] args) {

        Stream<Sample> sampleStream = Stream.of(new Sample("Hoo", 1), new Sample("Hao", 2),
                new Sample("Hoa", 3), new Sample("Hoop", 4), new Sample("AHoo", 5),
                new Sample("Hooda", 6), new Sample("Hoertryo", 7));

        HashMap<String, Integer> beforeMap = // NB: метод toMap возвращает Map, а не HashMap!
                new HashMap<>(sampleStream.collect(Collectors.toMap(s -> s.getKey(), Sample::getValue)));
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
