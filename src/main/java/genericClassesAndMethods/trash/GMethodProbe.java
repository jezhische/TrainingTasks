package genericClassesAndMethods.trash;

/**
 * Created by Ежище on 04.01.2017.
 */
public class GMethodProbe {
    static <T, E> T plus (T t, E e) {
        return (T) (e);
    }

    public static void main(String[] args) {
        long a = plus(12, 11);
        System.out.println(a);
    }
}
