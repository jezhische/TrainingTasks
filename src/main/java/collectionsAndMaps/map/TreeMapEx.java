package collectionsAndMaps.map;

import java.util.*;

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

        /* создать сет из таблицы (здесь с записями Entry<K, V>)**/
        Set<Map.Entry<Boo, String>> set = third.entrySet();
        /* создать таблицу из сета с записями Entry<K, V> **/
        System.out.print("\nset: ");
        for (Map.Entry<Boo, String> entry : set)
            System.out.printf("key = %s, value = %s; ", entry.getKey(), entry.getValue());
        Map<Boo, String> map = new TreeMap<>(comparator1); // NB без компаратора не выйдет сравнить объекты Boo
        for (Map.Entry<Boo, String> entry : set)
            map.put(entry.getKey(), entry.getValue());
        System.out.print("\nmap: ");
        for (Map.Entry<Boo, String> entry : map.entrySet())
            System.out.printf("key = %s, value = %s; ", entry.getKey(), entry.getValue());

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
