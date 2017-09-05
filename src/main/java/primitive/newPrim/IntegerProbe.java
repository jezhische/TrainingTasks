package primitive.newPrim;

import java.text.NumberFormat;
import java.util.Formatter;

/**
 * Created by WORK_x64 on 05.09.2017.
 */
public class IntegerProbe {
    static A method(A a) {
        return a;
    }
    public static void main(String[] args) {
        method(new A() {});
        method(new B());

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 31) - 1);
        System.out.println(0b11111111_11111111_11111111_11111111);


        float f = 123.45678f;
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        System.out.println(numberFormat.format(f));

        System.out.println("4/2=" + 4/2 == "4/2=2");

        A a = new B();
        a.b();

        A aa = new A() {};

        B bb = new B(){
            public void print(){
            System.out.println("Анонимный класс от обычного - супер! Но не работает этот метод");
        }};

        Integer I1 = 0;
        Integer I2 = -1;
        Integer I3 = 1;
        Formatter formatter = new Formatter();
        formatter.format("%1$b ", I1.toString())
                .format("%1$b ", I2.toString())
                .format("%1$b ", I3.toString());
        System.out.println(formatter.toString());

        int i = 1;
        long j = 1;
        if (i == 1) {
            int k = 1;
            if (i == k) {
                System.out.println("i equals k");
            }
        } /*else if (j == k) { // здесь k из другого стека, область видимости для k отсюда недоступна
            System.out.println("j equals k");
        }*/

    }
}
abstract class A {
    void a() {
        System.out.println("A-a");
    }

    void b() {
        System.out.println("A-b");
        a(); // хо-хо! дя объекта типа B здесь будет вызван его метод a()!
    }
}

class B extends A {
    void a() {
        System.out.println("B-a");
    }

    void b() {
        System.out.println("B-b");
        super.b();
    }
}
