package reference.passingByValueOrReference.newProbe;

import collectionsAndMaps.list.arrayList.ArraysAsList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStrigProbe {
    private static void doSomethingWithList(List<String> list) {
        if (!list.isEmpty()) {
            list.set(0, "ororo");
            list = new ArrayList<String>();
            list.add("uiui");
        }
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hu");
        doSomethingWithList(list);
        System.out.println(list); // console: [ororo]
    }
}
