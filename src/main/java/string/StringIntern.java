package string;

/**
 * Created by WORK_x64 on 29.12.2016.
 */
public class StringIntern {
    public static void main(String[] args) {
//  Здесь a и sameA создаются через литерал, а anotherA - это уже ссылка на новый объект:
        String a= "ddd", b, sameA = "ddd", anotherA = new String("ddd");
        char[] c = {'d', 'd', 'd'};
// b здесь также создается как новый объект:
        b = String.valueOf(c);
//  Здесь вернется false, поскольку a и b указывают на разные объекты:
        System.out.println("a == b : " + (a == b));
        System.out.println("a.equals(b) : " + a.equals(b));
//  Вот здесь вернется true, поскольку когда определяем стринг через литерал, этот стринг автоматически передается в пул,
// и новый литерал с таким же значением будет ссылаться на объект, уже хранящийся в пуле:
        System.out.println("a == sameA : " + (a == sameA));
//  А вот здесь вернется false, поскольку создается новый объект, а не ссылка на объект из пула:
        System.out.println("a == anotherA : " + (a == anotherA));
//  А вот после следующей операции ссылка anotherA переместится на объект, хранящийся в пуле:
        anotherA = anotherA.intern();
        System.out.println("a == anotherA : " + (a == anotherA));
        System.out.println("-----------------------------------------------");


//        Ну, а дальше - всякая хрень...
        System.out.println("\na.intern() == b.intern() : " + (a.intern() == b.intern()));
        System.out.println("a == b.intern() : " + (a == b.intern()));
        String k = b.intern();
        System.out.println("a == (k = b.intern()) : " + (a == k));


        String d = "ddd";
        System.out.println("\na == d : " + (a == d));

        String aa = String.valueOf(c);
        System.out.println("\naa == b : " + (aa == b));

        String e = "ggg", f = e;
        System.out.println("\ne == f : " + (e == f));
        f = "ggg";
        System.out.println("e == f : " + (e == f));
        f = "hhh";
        f = "ggg";
        System.out.println("e == f : " + (e == f));
    }
}
