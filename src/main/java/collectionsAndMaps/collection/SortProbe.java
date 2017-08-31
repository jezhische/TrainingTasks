package collectionsAndMaps.collection;

/** http://www.intuit.ru/studies/courses/16/16/lecture/27131?page=2 */
import java.util.*;

public class SortProbe {
    private class TestObject {
        private String name = "";
        public TestObject(String name) {
            this.name = name;
        }
    }
    private class MyComparator implements Comparator {
        public int compare(Object l,Object r) {
            String left = (String)l;
            String right = (String)r;
            return -1 * left.compareTo(right); // reverse comparator
        }
    }
    public SortProbe() {
    }

    public static void main(String[] args) {
        SortProbe test = new SortProbe();
        Vector v = new Vector();
        v.add("bbbbb");
        v.add("aaaaa");
        v.add("ccccc");
        System.out.println("Default elements order");
        test.dumpList(v);
        Collections.sort(v);
        System.out.println("Default sorting order");
        test.dumpList(v);
        System.out.println("Reverse sorting order with providing imlicit comparator");
        Collections.sort(v,test.new MyComparator());
        test.dumpList(v);
    }
    private void dumpList(List l) {
        Iterator it = l.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
