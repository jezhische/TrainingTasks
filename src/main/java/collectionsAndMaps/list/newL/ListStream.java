package collectionsAndMaps.list.newL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStream {
    public static void main(String[] args) {
        List<String> list = Stream.of("bm ", "ujhk ", "jhkjhj ", "fedsg ").collect(Collectors.toList());

        list.addAll(Stream.of("fggf ", "jkjkjkjkkjl ", "trtr ", "43 ").collect(
                () -> new ArrayList<String>(),
                (alist, string) -> alist.add(string + "; "),
                (list1, list2) -> list1.addAll(list2)));

        list.addAll(Stream.of("546 ", "879879 ").collect(ArrayList::new, ArrayList::add, ArrayList::addAll));

        list.forEach(System.out::print);
    }
}
