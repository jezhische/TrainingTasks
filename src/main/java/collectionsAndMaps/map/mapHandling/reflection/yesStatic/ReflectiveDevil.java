package collectionsAndMaps.map.mapHandling.reflection.yesStatic;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ежище on 15.04.2017.
 */
public class ReflectiveDevil {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        DataMap dataMap = DataMap.getInstance();
        dataMap.printData();
        System.out.println();

        Class ripper = dataMap.getClass();
        Field dataField = ripper.getDeclaredField("data");
        dataField.setAccessible(true);
        Map<Integer, String> dataRipper = (HashMap<Integer, String>)dataField.get(dataMap);
        for(Map.Entry<Integer, String> entry : dataRipper.entrySet()) {
            System.out.print(entry + "; ");
        }
        System.out.println();
        dataRipper.clear();
        dataRipper.put(5, "again");
        // we can see here, that the origin map is changed too, so we have got really reference
        // for map, not the map copy only:
        dataMap.printData();
        System.out.println();
    }
}
