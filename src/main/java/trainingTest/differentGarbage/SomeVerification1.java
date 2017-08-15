package trainingTest.differentGarbage;

import java.io.Console;
import java.io.IOException;
import java.util.*;

/**
 * Created by Ежище on 04.11.2016.
 */
public class SomeVerification1 {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
//        System.out.println(Integer.valueOf(""));
//        System.out.println(Integer.parseInt(""));
        String s = "";
        char c[] = s.toCharArray();
//        int[] a = new int[s.length()];
        System.out.println("c.length = " + c.length);
        for (int i = 0; i < s.length(); i++) {
            System.out.print("c[i] = " + c[i]);
        }
        System.out.println("NumericValue of 'r' = " + Character.getNumericValue('r'));

        ArrayList<String> my_list = new ArrayList<String>();
        for (int i = 0; i <my_list.size(); i++)
        {
            my_list.add("");
            System.out.println("iteration is done");
        }
        System.out.println("my_list = " + my_list);

//        for (char d='a'; d<='z'; d++) {
//            System.out.println("code="+(int)d+"\tsymbol="+d);
//        }


//        char ch ;
//        int code ;
//        try {
//            while ( -1 != (code = System.in.read ()) )
//            {
//                ch = (char) code ;
//                System.out.println ( "you pressed: '" + ch + "', code is " + code ) ;
//
//                // выйти когда нажато 'q'
//                if ( 'q' == ch )
//                {
//                    System.exit ( 0 ) ;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Scanner scan = new Scanner(System.in);
//        System.out.println(Integer.parseInt(scan.next()));
        int r, t, y;
        y = 9;
        r = y;
        t = y;
        t = 12;
        System.out.println("r = " + r + ", y = " + y);

        Integer q = new Integer(1);
        Integer w = new Integer(2);
        Integer e = new Integer(3);
        q = e;
        w = e;
        e = 67;
        w = 99;
        System.out.println("q" + q + ", w" + w + ", e" + e);

        ArrayList<Integer> oy = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            oy.add(10 + i);
        ArrayList<Integer> ou = oy;
        ArrayList<Integer> oi = oy;
        System.out.println("oy" + oy + ", ou" + ou + ", oi" + oi);
        oy.set(0, 45);
        ou.set(1, 78);
        System.out.println("oy" + oy + ", ou" + ou + ", oi" + oi);

        String zz = "zz";
        String xx = zz;
        xx = "xx";
        System.out.printf("xx = %s, zz = %s", xx, zz);

        class Zhuzhka implements Cloneable {
            String name;
            int age;
            Zhuzhka(String name, int age) {
                this.name = name;
                this.age = age;
            }
            public  Zhuzhka clone() throws CloneNotSupportedException {
                return (Zhuzhka)super.clone(); // вызывается clone() для родительского класса
                // Object, и получившийся клонированный образец приводится к типу Zhuzhka.
            }
        }
        Zhuzhka vasya = new Zhuzhka("Vasya", 123);
        System.out.printf("Жужку vasya зовут %s, ему %d года", vasya.name, vasya.age);
        Zhuzhka petr = vasya;
        petr.name = "Petr";
        System.out.printf("\nЖужку vasya теперь зовут %s, ему %d года. А Жужку petr зовут %s, ему %d года.",
                vasya.name, vasya.age, petr.name, petr.age);
        Zhuzhka kolya = vasya.clone();
        kolya.age = 253;
        System.out.printf("\nЖужку vasya теперь зовут %s, ему %d года. А Жужку petr зовут %s, ему %d года. А жужка kolya" +
                " с ними согласен, его зовут %s, но ему %d года.",
                vasya.name, vasya.age, petr.name, petr.age, kolya.name, kolya.age);

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        System.out.println("\n" + calendar.get(Calendar.YEAR));

        Console console = System.console();
// если удалось получить объект Console
        if (console != null) {
            Calendar cc = new GregorianCalendar();
            console.printf("Сайт %1$s%n", "Javadevblog.com"); //распечатает Сайт Javadevblog.com"
            console.printf("Текущее время: %1$tm %1$te,%1$tY%n", cc); //печатаем "Текущее время: 13 12,2015"
            console.flush();
        } else {
            System.out.println("Объект Console не получен");
        }
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        System.out.println("Текущее время в миллисекундах : " + currentTimeMillis);
        System.out.println(date);

        long nanoTime = System.nanoTime();
        System.out.println("Текущее время в наносекундах : " + nanoTime);

        //получаем переменные среды в виде коллекции Map
//и просматриваем каждую
        Map<String, String> envMap = System.getenv();
        Set<String> keySet = envMap.keySet();
        for(String key : keySet){
            System.out.println("Ключ : " + key + " | значение : " + envMap.get(key));
        }

// получаем определенную переменную среды
        String pathValue = System.getenv("PATH");
        System.out.println("$PATH=" + pathValue);

//        System.out.print("System.in.read() = ");
////        while(System.in.read() != (int)'q')
//            System.out.print(System.in.read() + ", ");
//        if(System.in.read() == (int)'q')
//            System.exit(0);
    }
}
