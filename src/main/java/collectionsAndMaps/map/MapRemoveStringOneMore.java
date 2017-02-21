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
        /* более сложный способ: **/
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(buildText.toString());
//        String textAnotherWay[] = null;
//        int count = matcher.groupCount();
//        if (count != 0)
//            textAnotherWay = new String[count];
//        for (int i = 0; i < count; i++)
//            textAnotherWay[i] = matcher.group();




        NavigableMap<String, Integer> map = new TreeMap<>();
        int i = 0;
        while(matcher.find()) {
            map.put(matcher.group(), i);
            i++;
        }
//        String textAnotherWay[] = new String[i];
        if (map.size() != 0) {
            for (Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();)
                System.out.print(iterator.next().getKey() + ":" + iterator.next().getValue() + "; ");
        }

        System.out.println(buildText.toString());
        System.out.println(Arrays.toString(text));
        System.out.println(map.size());
//        System.out.println(Arrays.toString(textAnotherWay));
//        System.out.println(count);


    }
}
