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
        /* простой способ порезать текст на слова: **/
        String[] text = buildText.toString().split("\\W+");
//        StringTokenizer st = new StringTokenizer(buildText.toString());
//        ArrayList<String> text2 = new ArrayList<>();
//        while(st.hasMoreElements())
//            text2.add(st.nextToken(" "));
        NavigableMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < text.length; i++)
            map.put(text[i], i);
        Map.Entry<String, Integer> en = map.lastEntry();
        System.out.println(map.get("specify"));
        System.out.println(en.getKey() + en.getValue());
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet)
            System.out.print(entry.getKey() + "_" + entry.getValue() + "; ");

//        for (Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();iterator.hasNext();)
//            iterator.next();
//            System.out.print(m.getKey() + "_" + m.getValue() + "; ");
        System.out.println();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
//        map.remove("specify");
        System.out.println(iterator.next());


//        /* более сложный способ: **/
//        Pattern pattern = Pattern.compile("\\w+");
//        Matcher matcher = pattern.matcher(buildText.toString());
////        String textAnotherWay[] = null;
////        int count = matcher.groupCount();
////        if (count != 0)
////            textAnotherWay = new String[count];
////        for (int i = 0; i < count; i++)
////            textAnotherWay[i] = matcher.group();
//
//
//
//
//        NavigableMap<String, Integer> map = new TreeMap<>();
//        int i = 0;
//        while(matcher.find()) {
//            map.put(matcher.group(), i);
//            i++;
//        }
////        String textAnotherWay[] = new String[i];
//        if (map.size() != 0) {
//            for (Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();)
//                System.out.print(iterator.next().getKey() + ":" + iterator.next().getValue() + "; ");
//        }

        System.out.println(buildText.toString());
        System.out.println(Arrays.toString(text));

//        System.out.println(text2);
//        System.out.println(map.size());
//        System.out.println(Arrays.toString(textAnotherWay));
//        System.out.println(count);


    }
}
