package genericClassesAndMethods.trash;

/**
 * Created by WORK_x64 on 04.01.2017.
 * http://blog.xapie.nz/2013/12/01/erasure/
 */
public class TypeErasure <T> {
    T value1, value2;
    public static <T> TypeErasure<T> create (Object o, Object e) {
        TypeErasure <T> tpe = new TypeErasure<T>();
        tpe.value1 = (T) o;
        tpe.value2 = (T) e;
        return tpe;
    }
    public void print () {
        System.out.println(value1);
        System.out.println(value2);
    }

    public static void main(String[] args) {
        Double pi = 3.14;
        String hello = "hello";
        TypeErasure <Integer> test = create(pi, hello);
//        System.out.println(test.value1 + test.value2); // вот так будет ошибка компиляции: ClassCastException:
// java.lang.Double cannot be cast to java.lang.Integer.
        test.print(); // а вот так все нормально: во время составления байт-кода типы стираются, и при выполнении
        // операции производятся над объектами Object.
        // Странно, что вот так все в порядке:
        System.out.println(test.value1);
        System.out.println(test.value2);
        // а вот так ошибка:
//        System.out.println(test.value1.getClass());
    }
}
