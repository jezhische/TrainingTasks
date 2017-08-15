package interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by Ежище on 20.02.2017.
 */
public class MapRemoveString {
    /* см. также package collectionAndMaps.map **/
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println((int) 'a');
        /* наполним map стрингами: **/
        for (int i = 20; i > 0; i--)
            map.put("ok" + String.valueOf((char)((int)(Math.random() * 10 + 95))) + "ko",
                    String.valueOf((char)((int)(Math.random() * 10 + 95))));
        /* и распечатаем: **/
        map.forEach((k, v) -> System.out.print(k + "," + v + "; "));
        /* удалим все записи, где ключ содержит 'a': **/
                        /* TODO: ВОТ ТАК НИ ХРЕНА НЕ ВЫЙДЕТ: **/
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if (entry.getKey().contains("a"))
                                map.remove(entry);
                        }
                        /* и распечатаем снова: **/
                        System.out.println();
                        map.forEach((k, v) -> System.out.print(k + "," + v + "; "));

        /* попробуем еще раз, получив доступ к итератору: **/
        for (Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
            if (iterator.next().getKey().contains("a"))
                iterator.remove();
        }
        System.out.println();
        map.forEach((k, v) -> System.out.print(k + "," + v + "; "));


        // TODO: вот как эта запись выглядит, если использовать метод removeIf(Predicate<? super E> filter)
        // из интерфейса Collection<E>  (откуда в Map берется Collection: метод entrySet() возвращает
        // Set<Map.Entry<K, V>>, а этот Set, в свою очередь, имплементирует интерфейс Collection<E>:
        map.entrySet().removeIf(s -> s.getKey().contains("a"));
        // В данном случае это так: Predicate<T> - это boolean-valued function с методом test(Object). Расписываем
        // это так:
        Predicate<Map.Entry<String, String >> predicate = entry -> entry.getKey().contains("a");
        // Саму по себе запись Map.Entry<String, String > мы получаем при итерировании
        // сета Set<Map.Entry<String, String>> set = map.entrySet();
        // TODO: это итерирование обеспечивает сам метод removeIf: "Removes all of the elements of this collection that
        // satisfy the given predicate". Так что все, что нужно - это создать предикат, использовав для лямбды
        // подходящий метод. Интерфейс выглядит так:
        // TODO: public interface Predicate<T> {boolean test(T t);}
        // Так что лямбда выглядит так:
        Predicate<String> sPred = (s) -> s.contains(""); // (где s - это образец класса String, аргумент
        // метода test(T t), то же, что T t)
        // (метод boolean contains(CharSequence s) вполне подходит для переопределения boolean test(T t))
        // Мы получаем образец String, добывая его из записи Map.Entry<String, String> с помощью метода getKey(),
        // и далее вызываем его метод contains("")
    }
}
