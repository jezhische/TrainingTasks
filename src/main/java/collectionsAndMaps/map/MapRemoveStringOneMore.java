package collectionsAndMaps.map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

/**
 * Created by WORK on 21.02.2017.
 */
public class MapRemoveStringOneMore {
    /* см. также package interview **/
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
        /* простой способ порезать текст на слова и набить ими массив: **/
        String[] text = buildText.toString().split("\\W+");

        /* проверим:**/
        System.out.println(buildText.toString());
        System.out.println(Arrays.toString(text));

        /* Не слишком получившийся способ: **/
//        StringTokenizer st = new StringTokenizer(buildText.toString());
//        ArrayList<String> text2 = new ArrayList<>();
//        while(st.hasMoreElements())
//            text2.add(st.nextToken(" "));

        //        /* более сложный способ: fixme - нужно взять коллекцию вместо массива: **/
//        Pattern pattern = Pattern.compile("\\w+");
//        Matcher matcher = pattern.matcher(buildText.toString());
////        String textAnotherWay[] = null;
////        int count = matcher.groupCount();
////        if (count != 0)
////            textAnotherWay = new String[count];
////        for (int i = 0; i < count; i++)
////            textAnotherWay[i] = matcher.group();
//        NavigableMap<String, Integer> map = new TreeMap<>();
//        int i = 0;
//        while(matcher.find()) {
//            map.put(matcher.group(), i);
//            i++;
//        }

        /* создаем таблицу и используем массив стрингов как ее ключи: **/
        NavigableMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < text.length; i++)
            map.put(text[i], i);
        /* поперебираем, распечатаем: **/
        Map.Entry<String, Integer> en = map.lastEntry();
        System.out.println(map.get("specify"));
        System.out.println(en.getKey() + en.getValue());
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        /* перебор значений через цикл foreach - но здесь нельзя удалять значения: **/
        for (Map.Entry<String, Integer> entry : entrySet)
            System.out.print(entry.getKey() + "_" + entry.getValue() + "; ");

        /* так можно распечатать только целиком entry, или только ключи, или только значения. При попытке взять ключ,
         * а затем еще и значение, итератор за одну итерацию цикла будет совершать 2 собственных итерации, и
          * в конце перебора выскочит за границы, определенные hasNext**/
        for (Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();iterator.hasNext();)
            System.out.print(iterator.next() + "; ");
        System.out.println();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        /* если я удалю элемент при созданном итераторе, а потом обращусь к итератору,
        * получу ConcurrentModificationException: **/
//        map.remove("specify");
        System.out.println(iterator.next());

    }
}
