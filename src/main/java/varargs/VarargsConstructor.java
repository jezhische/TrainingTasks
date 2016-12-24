package varargs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 24.12.2016.
 */
public class VarargsConstructor {
    String a, b;
    Object obj;
    List parList;
    VarargsConstructor(Object... par) {
        a = (String)par[0];
        b = (String)par[1];
        obj = par[2];
        parList = new ArrayList();
        for (int i = 0; i < par.length; i++)
            parList.add(i, par[i]);
    }
    VarargsConstructor(String... ddd) {
        parList = new ArrayList();
        for (int i = 0; i < ddd.length; i++)
            parList.add(i, ddd[i]);
    }

    public static void main(String[] args) {
        VarargsConstructor var = new VarargsConstructor();
        VarargsConstructor newVar = new VarargsConstructor("jiji", "hvst", var.obj);
        VarargsConstructor elseVar = new VarargsConstructor("bul");
        VarargsConstructor newElseVar = new VarargsConstructor("bul", "kva", "tri", newVar.getClass(), new Object());

        System.out.println(var.parList);
        System.out.println(newVar.parList);
        System.out.println(elseVar.parList);
        System.out.println(newElseVar.parList);
    }
}
