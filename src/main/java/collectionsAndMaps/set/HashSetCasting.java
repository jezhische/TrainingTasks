package collectionsAndMaps.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Ежище on 18.06.2017.
 */
public class HashSetCasting {
    public static void main(String[] args) {
        Set<String> ls = new LinkedHashSet<>();
        ls.add("a");
        Set<String> hs = (HashSet<String>)ls;
        System.out.println(hs);
        LinkedHashSet<String> lls = new LinkedHashSet<>(ls);
        System.out.println(lls);
        HashSet<String> hhs = new HashSet<String> (lls);
        System.out.println(hhs);
        System.out.println("" + ls.getClass() + hs.getClass() + lls.getClass() + hhs.getClass());
    }
}
