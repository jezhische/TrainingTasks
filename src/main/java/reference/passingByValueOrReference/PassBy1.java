package reference.passingByValueOrReference;

/**
 * Created by Ежище on 23.12.2016.
 */
public class PassBy1 {
    int a;
    int increment(int a) {
        return ++a;}

    Object giveMeAString (Object y) {
        y = "This is a string";
        return y;
    }
    Object z;

    public static void main(String[] args) {
        PassBy1 passBy1 = new PassBy1();
//        passBy1.a = 5;
        passBy1.increment(passBy1.a);
        System.out.println("passBy1.a = " +  passBy1.a);
        System.out.println("passBy1.increment(passBy1.a) = " + passBy1.increment(passBy1.a));

        Object x = null;
        System.out.println("the value of object x is: " + x);
        passBy1.giveMeAString (x); // в метод передается значение объекта x по ссылке "x". Метод КОПИРУЕТ значение
        // объекта x и работает с этим значением, и возвращает новое значение (и даже новый класс объекта, см.ниже).
        // Однако, значение самого объекта x не меняется.
        System.out.println ("after method implementing, the value of object x is: " + x);
        System.out.println();

        passBy1.z = new Object();
        System.out.println ("passBy1.z = " + passBy1.z);
        passBy1.giveMeAString (passBy1.z); // в метод передается значение объекта passBy1.z по ссылке "passBy1.z"
        System.out.println ("after passing in method: passBy1.z = " + passBy1.z);
        System.out.println("method returns new value: " + passBy1.giveMeAString (passBy1.z));
        System.out.println("method returns new class of passed-in object: " + passBy1.giveMeAString (passBy1.z).getClass());
        System.out.println("but the class of the passBy1.z = " + passBy1.z.getClass());
    }
}
