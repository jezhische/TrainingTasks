package genericClassesAndMethods.trash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 28.12.2016.
 */
public class CastProbe<E> {
    public E sum(E number) {
        if (number.getClass().equals(Integer.class))
            return (E) ((Integer) ((Integer) number * 2));
        return null;
    }

    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
//        List<Object> objList = strList; // компилятор сразу определяет ClassCastException, несмотря на наследование
//        // String от Object
        List<Number> numbList = new ArrayList<>();
//        List<Integer> intList = numbList; // тоже не проходит


        CastProbe cp = new CastProbe();
        CastProbe<Object> cp2 = new CastProbe<>();
        CastProbe<Integer> cip = cp; // ругается, но проходит
        //    {cip = cp2;} // а вот так уже ClassCastException
        CastProbe<Integer> cip2 = new CastProbe<>();
        CastProbe cp3 = cip2; // даже не ругается
//    {cp2 = cip;} // ClassCastException
        System.out.println(cp.sum(5));
        System.out.println(cp.sum("5")); // здесь Object number
        System.out.println(cip.sum(23)); // а здесь Integer number
//        System.out.println(cip.sum("jkjk")); // так что вот это не проходит
    }
}
