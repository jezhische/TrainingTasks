package collectionsAndMaps.map.newM;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapCompute {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public class Mapper {
        private Integer key;
        private String value;

        public Mapper(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> weak = new WeakHashMap<>();
        weak = (WeakHashMap<Integer, String>) weak;
//        System.out.println(weak instanceof WeakHashMap);
//        System.out.println(weak.getClass().isInterface());
//        System.out.println(weak.getClass().isInstance(new WeakHashMap<>()));
        weak.putAll(ForEachRemaining.map);
        weak.entrySet().forEach((entry) -> System.out.print(entry + "; "));
        System.out.println();
        weak.compute(0, (k, v) -> k > 0? ((v == null) ? "yopp" : v.concat("yopp")): "horjo");
        weak.entrySet().forEach((entry) -> System.out.print(entry + "; "));
        System.out.println();
        weak.computeIfAbsent(3, (k) -> "nonono");
        weak.entrySet().forEach((entry) -> System.out.print(entry + "; "));
        System.out.println();
        weak.computeIfPresent(3, (k, v) -> v.matches("(no){3}?")? "hruu": null);
        weak.entrySet().forEach((entry) -> System.out.print(entry + "; "));
        System.out.println();
        weak.computeIfPresent(3, (k, v) -> v.matches("(hruu)+?")? "gu": null);
        weak.entrySet().forEach((entry) -> System.out.print(entry + "; "));
        System.out.println();

        List<Integer> list = new ArrayList<>();
        weak.entrySet().forEach((entry) -> {if(entry.getValue().contains("j")) list.add(entry.getKey());});
        // 1 способ:
//        Iterator<Map.Entry<Integer, String>> iter = weak.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry<Integer, String> entry = iter.next();
//            if (list.contains(entry.getKey())) iter.remove();
//        }

        // 2 способ:
//        list.forEach(weak::remove);

        // 3 способ:
        weak.entrySet().removeIf(entry -> list.contains(entry.getKey()));

        weak.entrySet().forEach((entry) -> System.out.print(entry + "; "));
        System.out.println();

        weak.computeIfAbsent(4, k -> "geostamp");
        weak.putIfAbsent(5, "tapotu");

        // todo: TOMAP:  <T, K, U> java.util.stream.Collector<T, ?, java.util.Map<K, U>>
        // = Collectors.toMap(@NotNull java.util.function.Function<? super T, ? extends K> (todo:) keyMapper,
        // @NotNull java.util.function.Function<? super T, ? extends U> (todo:) valueMapper)
        MapCompute mc = new MapCompute();
        Stream<MapCompute.Mapper> stream = Stream.of(mc.new Mapper(6, "trototop"), mc.new Mapper(7, "horro"));
        weak.putAll(stream.collect(Collectors.toMap(MapCompute.Mapper::getKey, MapCompute.Mapper::getValue)));
        weak.entrySet().forEach((entry) -> System.out.print(entry + "; "));
        System.out.println();

//        String s = "ghh";
//        s.matches("[o]")
        weak.entrySet().stream().collect(ArrayList<Integer>::new,
                (alist, entry) -> {
            if (entry.getValue().matches("[k]+")) alist.add(entry.getKey());},
                ArrayList<Integer>::addAll)
                .forEach(weak::remove);
        weak.entrySet().forEach((entry) -> System.out.print(entry + "; "));
        System.out.println();
    }
}
