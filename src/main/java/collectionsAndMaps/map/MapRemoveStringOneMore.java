package collectionsAndMaps.map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.regex.*;

/**
 * Created by WORK on 21.02.2017.
 */
public class MapRemoveStringOneMore {

    /* TODO: см. также package interview **/

    public static void main(String[] args) {

        /* добываем текст из файла: **/
        StringBuilder buildText = new StringBuilder();
        try(FileReader reader = new FileReader("src\\main\\java\\collectionsAndMaps\\map\\" +
                "MapRemoveStringOneMoreSupply")) {
            int i;
            while((i = reader.read()) != -1)
                buildText.append((char)i);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /* проверим:**/
        System.out.println("buildText =     " + buildText.toString());
        /* TODO: простой способ порезать текст на слова и набить ими массив: **/
        String[] text = buildText.toString().split("\\W+");
        /* проверим:**/
        System.out.printf("String[] text (length = %d) = %s\n", text.length, Arrays.toString(text));

        /* TODO: Создаем таблицу и используем массив стрингов text как ее ключи: **/
        NavigableMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < text.length; i++)
            map.put(text[i], i); // i превращается в Integer из примитива благодаря autoboxing
//        /* поперебираем, распечатаем: **/
//        Map.Entry<String, Integer> en = map.lastEntry();
//        System.out.println(map.get("specify"));
//        System.out.println(en.getKey() + en.getValue());

        /* TODO: перебор значений через цикл foreach - но здесь нельзя удалять значения: **/
//        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        System.out.printf("\nmap with foreach loop (size = %d):    ", map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.print(entry.getKey() + "_" + entry.getValue() + "; ");

        /* TODO: Вот так можно распечатать или только целиком entry, или только ключи, или только значения. При попытке
         * взять ключ, а затем еще и значение, итератор за одну итерацию цикла будет совершать 2 собственных итерации,
         * и в конце перебора выскочит за границы, определенные hasNext: **/
        System.out.printf("\nmap entries print with iterator (size = %d):    ", map.size());
        for (Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();iterator.hasNext();)
            System.out.print(iterator.next() + "; ");
        System.out.println();

        /* TODO: как получить ConcurrentModificationException:  **/
//        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
//        /* если я удалю элемент при созданном итераторе, а потом обращусь к итератору,
//        * получу ConcurrentModificationException: **/
////        map.remove("specify");
//        System.out.println(iterator.next());

        /* Не слишком получившийся способ порезать стринг: **/
//        StringTokenizer st = new StringTokenizer(buildText.toString());
//        ArrayList<String> text2 = new ArrayList<>();
//        while(st.hasMoreElements())
//            text2.add(st.nextToken(" "));

        /* TODO: еще способ порезать стринг: **/
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(buildText.toString());
        /* теперь создаем таблицу и используем массив стрингов как ее ключи: **/
        NavigableMap<String, Integer> mapA = new TreeMap<>();
        int ii = 0;
        while(matcher.find()) {
            mapA.put(matcher.group(), ii);
            ii++;
        }
        /* убедимся, что матчер дошел до конца: **/
        System.out.println("matcher.hitEnd(): " + matcher.hitEnd() + ", matcher.find(): " + matcher.find() + "\n");
        System.out.printf("mapA with forEach (size = %d):    ", mapA.size());
        mapA.forEach((key, value) -> System.out.print(key + ":" + value + "; "));
//        /* TODO: Если это расписать через анонимный класс: **/
//        mapA.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String s, Integer integer) {
//                System.out.print(s + ":" + integer + "; ");
//            }
//        });

        /* TODO: еще способ порезать стринг: **/
        Matcher matcherB = pattern.matcher(buildText.toString());
        ArrayDeque<String> aDeque = new ArrayDeque<>();
        while(matcherB.find())
            aDeque.push(matcherB.group());
        /* проверим: **/
        System.out.println("\n\naDeque (size = " + aDeque.size() + "): " + aDeque);
        /* aDeque.pop() кидает NoSuchElementException, поэтому лучше воспользуемся aDeque.poll() (то же самое, но
        * возвращает null, если элементов больше не осталось). При использовании push() и poll() получаем, фактически,
         * не Queue, а Stack; чтобы получить Queue, нужно воспользоваться offer() вместо push() **/
        NavigableMap<String, Integer> mapB = new TreeMap<>();
        for (int i = aDeque.size() - 1; i >= 0; i--)
            mapB.put(aDeque.poll(), i);
        /* проверим: **/
        System.out.printf("mapB with forEach (size = %d):    ", mapB.size());
        mapB.forEach((s, i) -> System.out.print(s + ":" + i + "; ")); // NB: до сих пор из двух значений we:5 и we:16
        // (по ключу we) сохранялось we:16, поскольку мы листали с головы до хвоста массив элементов, расположенных
        // в том же порядке, что и исходный стринг. Но поскольку в этот стек aDeque мы добавляли элементы методом push(),
        // они добавлялись в голову и оказались расставлены в обратном порядке. Теперь вначале записывается we:16, а
        // потом поверх записывается we:5

        /* TODO: теперь сотрем через итератор те значения, ключ которых содержит "a": **/
        /* TODO: вот так нельзя, поскольку удаляем запись таблицы при созданном итераторе (выскакивает, по-видимому,
        * ConcurrentModificationException): **/
//        Map.Entry<String, Integer> entry = null;
//        for (Iterator<Map.Entry<String, Integer>> iter = mapB.entrySet().iterator(); iter.hasNext();) {
//            entry = iter.next();
//            if (entry.getKey().contains("a"))
//                mapB.remove(entry.getKey());
//        }
        for (Iterator<Map.Entry<String, Integer>> iter = mapB.entrySet().iterator(); iter.hasNext();)
            if (iter.next().getKey().contains("a"))
                iter.remove();
        /* проверим: **/
        System.out.printf("\nmapB with forEach (size = %d):    ", mapB.size());
        mapB.forEach((s, i) -> System.out.print(s + ":" + i + "; "));
            /* TODO: теперь сотрем те значения, ключ которых содержит более 4 символов: **/
        mapB.entrySet().removeIf(entry -> {return entry.getKey().length() > 4;});
         /* проверим: **/
        System.out.printf("\nmapB with forEach (size = %d):    ", mapB.size());
        mapB.forEach((s, i) -> System.out.print(s + ":" + i + "; "));
        /* TODO: если расписать метод removeIf через анонимный класс, это вглядит так (сократим длину ключей до 3): **/
        mapB.entrySet().removeIf(/* Predicate<? super Entry<String, Integer>>**/
                new Predicate<Map.Entry<String, Integer>>() {
            @Override
            public boolean test(Map.Entry<String, Integer> entry) {
                return entry.getKey().length() > 3;
            }
        });
                 /* проверим: **/
        System.out.printf("\nmapB with forEach (size = %d):    ", mapB.size());
        mapB.forEach((s, i) -> System.out.print(s + ":" + i + "; "));

    }
}
