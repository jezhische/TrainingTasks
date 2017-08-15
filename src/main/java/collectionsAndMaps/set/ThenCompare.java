package collectionsAndMaps.set;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by Ежище on 18.02.2017.
 */
public class ThenCompare {
    public static void printPerson(P person) {
        System.out.printf("%s, %d; ", person.name, person.age);
    }
    public static void main(String[] args) {
        /* todo: можно так: **/
//        NavigableSet<P> set = new TreeSet<P>((p1,  p2) -> {
//            return (p1.name.compareTo(p2.name) == 0)? ((Integer)p1.age).compareTo(((Integer)p2.age))
//                    : p1.name.compareTo(p2.name);
//        });

        /* todo: или так: **/
        NavigableSet<P> set = new TreeSet<P>(((Comparator<P>) (p1, p2) -> p1.name.compareTo(p2.name))
                .thenComparing((p1, p2) -> ((Integer)p1.age).compareTo(p2.age)));


        /* todo: так - только если по одному параметру сравнение: **/
        NavigableSet<P> setByName = new TreeSet<P>(Comparator.comparing(p -> p.name));

        P tom = new P(15, "Tom");
        P cat = new P(15, "Cat");
        P tom2 = new P(15, "Tom");
        P tom3 = new P(25, "Tom");
        set.add(tom);
        set.add(cat);
        set.add(tom2);
        set.add(tom3);
        set.forEach(ThenCompare::printPerson);

    }
}
class P {
    public int age;
    public String name;
    P(int age,String name) {
        this.age = age;
        this.name = name;
    }
}
