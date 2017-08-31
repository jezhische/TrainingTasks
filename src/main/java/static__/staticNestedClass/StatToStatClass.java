package static__.staticNestedClass;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatToStatClass {
    Nest nest;

    public Nest getNewNest() {
        return new Nest();
    }

    public Nest getNest() {
        return nest;
    }


    public static class Nest {
        public static String name;
        public String go;
        private Nest() {}
    }

    public class In {
//        public static String name; // так нельзя
//        public static final String name; // и так тоже
        public static final String name = "name Ou"; // можно только так
        public String go;
    }

    public String revert() {
        List<String> list = Arrays.asList(In.name.split(""));
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
//        return new In().go; // так можно
    }

    public String simpleReverce() {
        StringBuilder sb = new StringBuilder(In.name);
        sb.reverse();
        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        StatToStatClass.Nest.name = "uhu!";
//        StatToStatClass.Nest nest = new StatToStatClass.Nest(); // можно, когда конструктор не приватный
        StatToStatClass.Nest nest = new StatToStatClass().getNewNest();
        StatToStatClass.Nest nesty = new StatToStatClass().getNest();
        System.out.println(StatToStatClass.Nest.name);
        System.out.println(nest.name);
        System.out.println(nesty.name);

        String[] chars = StatToStatClass.In.name.split("");
        List<String> list = Arrays.asList(chars);
        Collections.reverse(list);
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        String s = sb.toString();
        System.out.println(s);
//        String s = String.valueOf(list);
//        System.out.println(s);


//        for (String stri: chars)
//            System.out.println(stri);
//
//        System.out.println(Arrays.deepToString(chars));
//        System.out.println(StatToStatClass.In.name);

        System.out.println(new StatToStatClass().simpleReverce());
    }
}
