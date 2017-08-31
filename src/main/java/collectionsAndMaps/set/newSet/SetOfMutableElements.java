package collectionsAndMaps.set.newSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetOfMutableElements {
    public static void main(String[] args) {
        HashSet<Mutable> set = new HashSet<>();
        for (int i = 0; i < 5; i++) set.add(new Mutable(i));
        set.forEach((m) -> System.out.println("a = " + m.getA() + ", hashCode = " + m.hashCode()));
        System.out.println(set.contains(new Mutable(3)));
        System.out.println();
        set.forEach((m) -> m.setA(5)); // прокатит, если не переопределять hashCode() в Mutable.
        set.forEach((m) -> System.out.println("a = " + m.getA() + ", hashCode = " + m.hashCode())); //Хотя вообще-то,
        // прокатило даже после переопределения.

        System.out.println("\n" + set.size());
        System.out.println(new Mutable(5).hashCode());
        System.out.println(set.contains(new Mutable(5)));
        Iterator<Mutable> iter = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            Mutable m = iter.next();
            if (i == 3) {
                System.out.println(m.equals(new Mutable(5)));
                break;
            }
        }
        System.out.println("-----------------");
        Iterator<Mutable> iterr = set.iterator();
        Mutable x = null;
        Mutable y = null;
        for (int i = 0; iterr.hasNext(); i++) {
            if (i % 2 == 0)
                x = iterr.next();
            else { y = iterr.next();
                System.out.println(x.equals(y));}
        }
        System.out.println();
        System.out.println("-------------------------------------------------");
        Mutable mut = new Mutable(4);
        set.forEach((m) -> m = mut);
        set.forEach((m) -> System.out.println("a = " + m.getA() + ", hashCode = " + m.hashCode()));
        System.out.println();
        for (int i = 0; i < 3; i++) set.add(mut);
        set.forEach((m) -> System.out.println("a = " + m.getA() + ", hashCode = " + m.hashCode()));
        System.out.println();
        for (int i = 0; i < 3; i++) set.add(new Mutable(5));
        set.forEach((m) -> System.out.println("a = " + m.getA() + ", hashCode = " + m.hashCode()));
        System.out.println();

        ArrayList<Mutable> list = set.stream().collect(ArrayList<Mutable>::new, ArrayList<Mutable>::add,
                ArrayList<Mutable>::addAll);
        System.out.println(list.size());
        System.out.println(list.get(1).equals(new Mutable(5)));
        set.addAll(list);
        set.forEach((m) -> System.out.println("a = " + m.getA() + ", hashCode = " + m.hashCode()));
        System.out.println(set.contains(list.get(0)));
        list.forEach(m -> m = mut);
        System.out.println(list);

    }
}
class Mutable {
    private int a;

    public Mutable(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mutable that = (Mutable) obj;
        if (a != 0? a == that.a: that.a == 0) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return a;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Mutable mutable = (Mutable) o;
//
//        return a == mutable.a;
//    }
//
//    @Override
//    public int hashCode() {
//        return a;
//    }
}

