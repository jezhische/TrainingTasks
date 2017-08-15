package collectionsAndMaps.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Ежище on 03.08.2016.
 */
public class TreeSetReference implements Comparable<TreeSetReference> {

    public TreeSet<TreeSetReference> tree = new TreeSet<>();

    private String name;

    private int age;

    public TreeSetReference() {}

    public TreeSetReference(String name) { this.name = name;}

    public TreeSetReference(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
}
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int compareTo(TreeSetReference core) {
        return name.compareTo(core.getName());
    }

    public static void main(String[] args) {
        TreeSetReference derevo = new TreeSetReference("zhuzhka");

        derevo.tree.add(new TreeSetReference("kjkj"));
        derevo.tree.add(new TreeSetReference("Kjkj"));
        derevo.tree.add(new TreeSetReference(" kjkj"));
        derevo.tree.add(new TreeSetReference("fdfd"));
        derevo.tree.add(new TreeSetReference("615+5"));

        System.out.println(derevo.tree.size());
        for (TreeSetReference gok: derevo.tree) {
            System.out.println(gok.getName());
        }
        System.out.println("\n");

            TreeSetComparator tsComp = new TreeSetComparator();
            TreeSet<TreeSetReference> treeComparator = new TreeSet<>(tsComp);
            treeComparator.add(new TreeSetReference("kjkj"));
            treeComparator.add(new TreeSetReference("Kjkj"));
            treeComparator.add(new TreeSetReference(" kjkj"));
            treeComparator.add(new TreeSetReference("fdfd"));
            treeComparator.add(new TreeSetReference("615+5"));

            System.out.println(treeComparator.size());
            for (TreeSetReference gu: treeComparator) {
                System.out.println(gu.getName());
        }
            System.out.println("");

            Comparator tsComp2 = new TreeSetComparator2();
            TreeSet<TreeSetReference> treeComparator2 = new TreeSet<>(tsComp2);
            treeComparator2.add(new TreeSetReference("kjkj"));
            treeComparator2.add(new TreeSetReference("Kjkj"));
            treeComparator2.add(new TreeSetReference(" kjkj"));
            treeComparator2.add(new TreeSetReference("fdfd"));
            treeComparator2.add(new TreeSetReference("615+5"));

            System.out.println(treeComparator2.size());
            for (TreeSetReference gu: treeComparator2) {
                System.out.println(gu.getName());
            }
            System.out.println("");

        Comparator<TreeSetReference> tsComp3 = new TreeSetNameComparator3().thenComparing(new TreeSetAgeComparator3());
        TreeSet<TreeSetReference> treeComparator3 = new TreeSet<>(tsComp3);
        treeComparator3.add(new TreeSetReference("knl", 123));
        treeComparator3.add(new TreeSetReference("knl", 222));
        treeComparator3.add(new TreeSetReference("Knl", 333));
        treeComparator3.add(new TreeSetReference("ujtuj", 1));
        treeComparator3.add(new TreeSetReference(" knl", 888));

        System.out.println(treeComparator3.size());
        for(TreeSetReference ni: treeComparator3) {
            System.out.println(ni.getName() + ", " + ni.getAge());
        }
        System.out.println("");
    }
}
class TreeSetComparator implements Comparator<TreeSetReference> {
    @Override
    public int compare(TreeSetReference o1, TreeSetReference o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class TreeSetComparator2 implements Comparator<TreeSetReference> {
    @Override
    public int compare(TreeSetReference o1, TreeSetReference o2) {
        return o1.getName().length() - o2.getName().length();
    }
}
class TreeSetNameComparator3 implements Comparator<TreeSetReference> {

    @Override
    public int compare(TreeSetReference o1, TreeSetReference o2) {
        return o1.compareTo(o2);
    }
}
class TreeSetAgeComparator3 implements Comparator<TreeSetReference> {

    @Override
    public int compare(TreeSetReference o1, TreeSetReference o2) {
        return o1.getAge() - o2.getAge();
    }
}