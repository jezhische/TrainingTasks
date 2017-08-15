package collectionsAndMaps.set;

import garbage.trash.enumProbes.Unit;

import java.util.EnumSet;

/**
 * Created by WORK_x64 on 09.01.2017.
 */
public class EnumSetInstance {
    static EnumSet<Unit> stringEnumSet = EnumSet.allOf(Unit.class);

    public static void main(String[] args) {
        System.out.println(stringEnumSet);
    }
}
