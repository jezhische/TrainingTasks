package genericClassesAndMethods.trash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 14.02.2017.
 */
public class _1TypeErasure {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        /*  instanceof - статическая ("с ранним связыванием", "static dispatching") проверка, является ли указанный
        * объект "assignment-compatible with the object represented by this Class"...............
        *в общем, надо разбираться, см. документацию по isInstance
        * **/
        System.out.println(list instanceof ArrayList);
        System.out.println(list instanceof List);
        System.out.println(list instanceof Object);
        System.out.println();

        System.out.println(list.getClass().equals(ArrayList.class));
        System.out.println(list.getClass().equals(List.class));
        System.out.println(list.getClass().equals(Object.class));
        System.out.println();

        System.out.println(list.getClass().isInstance(ArrayList.class));
        System.out.println(list.getClass().isInstance(List.class));
        System.out.println(list.getClass().isInstance(Object.class));
        System.out.println();

        List nonParametrizedList = new ArrayList();
        System.out.println(nonParametrizedList.getClass().isInstance(ArrayList.class));
        System.out.println(nonParametrizedList.getClass().isInstance(List.class));
        System.out.println(nonParametrizedList.getClass().isInstance(Object.class));

    }
}
