package immutability.breakingOfEncapsulation.testCollection;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Ежище on 16.04.2017.
 */
public class ReflectionWayToBreakEncapsulation {
    public static void main(String[] args) {
        PrivateDataStorageWithGetters pData = new PrivateDataStorageWithGetters();

        System.out.println("\nbefore breaking");
        System.out.println(pData.getPrivateStringList() + " " + pData.getPrivateFinalStringList() + " "
                + PrivateDataStorageWithGetters.getPrivateStaticFinalStringList() + " " +
                pData.getForReadingOnly() + " " + pData.getImmutableList() + "\n");

        Class ripper = pData.getClass();
        Field [] fields = ripper.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType().equals(List.class))
                    ((List<String>)field.get(pData)).set(0, "broken");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException in ReflectionWayToBreakEncapsulation: cannot change " +
                    "unmodifiableList: " +
                    e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // The cycle was interrupted  due to exception when we attempted to change forReadingOnly,
        // therefore we must to repeat operation with immutableList:
        try {
            Field lastField = ripper.getDeclaredField("immutableList");
            lastField.setAccessible(true);
            ((List<String>)lastField.get(pData)).set(0, "broken");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException in ReflectionWayToBreakEncapsulation: cannot change " +
                    "unmodifiableList: " +
                    e.getMessage());
        }

        System.out.println("\nafter breaking");
        System.out.println(pData.getPrivateStringList() + " " + pData.getPrivateFinalStringList() + " "
                + PrivateDataStorageWithGetters.getPrivateStaticFinalStringList() + " " +
                pData.getForReadingOnly() + " " + pData.getImmutableList());
    }
}
