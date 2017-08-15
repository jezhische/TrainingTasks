package collectionsAndMaps.map.mapHandling;

import java.util.*;

import static collectionsAndMaps.map.mapHandling.DataHashMap.data;

/**
 * Created by Ежище on 15.04.2017.
 */
public class MapSorting {
    public static void main(String[] args) {
        // todo: приводим к листу, перемешиваем, сортируем:
        List<Map.Entry<Integer, String>> list = new ArrayList<>(data.entrySet());

        Collections.shuffle(list);
        System.out.print(list);
        System.out.println();

        list.sort(Comparator.comparing(Map.Entry::getKey));
        System.out.print(list);
        System.out.println();

        // todo: перемешанный лист загоняем в LinkedHashMap, а ее потом в TreeMap:
        // todo: а если загнать в HashMap, сразу рассортирует по хэшу, видимо, а, наверное, хэш интов таков, что
        // сортировка получится по порядку.
        Collections.shuffle(list);
        LinkedHashMap<Integer, String> newData = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            newData.put(list.get(i).getKey(), list.get(i).getValue());
        }
        Iterator<Map.Entry<Integer, String>> iter = newData.entrySet().iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + "; ");
        }
        System.out.println();

        //ok, сортируем по value:
//        TreeMap<Integer, String> newDatanew = new TreeMap<Integer, String>((o1, o2) -> o1.getValue
//        }); // ну... не выходит...

        TreeMap<Integer, String> sortedData = new TreeMap<>(newData);
        Iterator<Map.Entry<Integer, String>> iteriter = sortedData.entrySet().iterator();
        while (iteriter.hasNext()) {
            System.out.print(iteriter.next() + "; ");
        }
        System.out.println();
    }
}
