package collectionsAndMaps.newCollectionTests;

import InterfaceAndFabricMethods.newItf.PolyInheritance;

import java.util.Arrays;
import java.util.Collection;

public class ResearchesAndProbes {
    static void printArray(Object[] array) {
        System.out.println(Arrays.asList(array));
    }

    public static void main(String[] args) {
        // просто проверки
        try {
            System.out.println(Collection.class);
            System.out.println(Collection.class.getSuperclass()); // интерфейсы не возвращает
            printArray(Collection.class.getInterfaces()); // возвращает derived interfaces
            printArray(PolyInheritance.class.getInterfaces()); // возвращает extended interfaces
//            System.out.println(Collection.class.getSuperclass().getSuperclass());
            System.out.println();

            System.out.println(Arrays.asList(new Integer(0)).getClass());
            System.out.println(Arrays.asList(new String("0")).getClass());
        } catch (NullPointerException e) {
            System.out.println("There are no superclass");
        }
    }
}
