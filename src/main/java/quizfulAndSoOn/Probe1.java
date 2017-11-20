package quizfulAndSoOn;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Probe1 extends Thread {
    // не обязан переопределять run()
    public static int i;
    public final static int j = 0;

    {
        p1:
        {
            p2:
            {
                p3:
                {
                    System.out.print("p3.1 ");
                    if (true) break p2;
                    System.out.print("p3.2 ");
                }
                System.out.print("p2 ");
            }
            System.out.print("p1 ");
        }
    }

    public void test(final Probe1 test) {
//        test = new Probe1(); // тут вот назначить новое значение для final уже нельзя
    }


    class B extends Probe2.A{ // A д.б. static, иначе к нему невозможно обратиться, пока не создан обект Probe2
        @Override
         protected int ou() {
            return super.a();
        }
    }


    public static final  void main(String[] args) { // ва-а-а! работает!!!
        System.out.println(i + " " + j);

        System.out.println(Integer.toBinaryString(0b1111_1111_1111_1111_1111_1111_1111_1111));
        System.out.println(Integer.toString(0b1111_1111_1111_1111_1111_1111_1111_1111));
        System.out.println(Integer.toBinaryString(0b1111_1111_1111_1111_1111_1111_1111_1111 + 1));
        System.out.println(Integer.toString(0b1111_1111_1111_1111_1111_1111_1111_1111 + 1));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE - 1));
        System.out.println(Integer.toString(Integer.MIN_VALUE - 1));
        System.out.println(Math.pow(2, 31) - 1);

        System.out.println();
        new Probe1();

        System.out.println();
        int a = 0;
        System.out.println("a=" + new Integer(a = 1));
        System.out.println(a = 2);

//        HashMap.Entry<Integer, String> entry = new HashMap<Integer, String>().entrySet().iterator().next();
        System.out.println(Collections.EMPTY_LIST.getClass());
        System.out.println(Collections.EMPTY_MAP.getClass());
        System.out.println(Collections.EMPTY_SET.getClass());
        Map map = Collections.EMPTY_MAP;
        System.out.println(map.getClass()); // но тип у нее - java.util.Map
//        map.put(new Object(), new String()); // UnsupportedOperationException
//        HashMap<Integer, String> ismap = (HashMap)map; // ClassCastException: java.util.Collections$EmptyMap cannot
        // be cast to java.util.HashMap

        Integer f = -+67;
//        ++a--;  // "The result of the prefix increment expression is not a variable, but a value."
        int y = -5;
        int x = +y;
        System.out.println(x); // -5

        if (false) throw new RuntimeException(); // unchecked можно не обрабатывать
        if (false) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
