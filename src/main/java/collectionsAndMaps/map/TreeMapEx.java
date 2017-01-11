package collectionsAndMaps.map;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by WORK_x64 on 11.01.2017.
 */
public class TreeMapEx {
    static TreeMap<Integer, String> first = new TreeMap<>();
    static TreeMap<Stick, String> second = new TreeMap<>();
    static TreeMap<Boo, String> third;


    public static void main(String[] args) {
        for (int i =10; i >= 0; i--)
        first.put(i,String.valueOf(i * 10) );

        System.out.println(first.get(3));
        for (Map.Entry<Integer, String> entry: first.entrySet())
            System.out.print(entry.getKey() + " " + entry.getValue() + "; ");
        System.out.println();

        Stick one = new Stick(1);
        Stick two = new Stick(2);
        second.put(one, "g");
        second.put(two, "gg");
        for (Map.Entry<Stick, String> entry: second.entrySet())
            System.out.print(entry.getKey() + " " + entry.getValue() + "; ");

        Comparator <Boo> comparator1 = new Comparator<Boo>() {
            @Override
            public int compare(Boo o1, Boo o2) {
                if (o1.q > o2.q)
                    return 1;
                else if (o1.q < o2.q)
                    return -1;
                else
                    return 0;
            }
        };
        third  = new TreeMap<>(comparator1);
        for (int i = - 10; i < 0; i++)
            third.put(new Boo(i), i + "sss");
        for (Map.Entry<Boo, String> entry: third.entrySet())
            System.out.print(entry.getKey() + " " + entry.getValue() + "; ");
    }
}
class Stick implements Comparable {
    int a;
    Stick (int a) {this.a = a;}
    @Override
    public int compareTo(Object o) {
        if (o instanceof Stick) {
            if (a > ((Stick) o).a)
                return 1;
            else if (a < ((Stick) o).a)
                return -1;
            else
                return 0;
        }

        return 0;
    }
}

class Boo {
    int q;
    Boo (int q) {this.q = q;}
}
