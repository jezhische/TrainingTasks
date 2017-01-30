package collectionsAndMaps.list;

import java.util.*;

/**
 * Created by Ежище on 28.01.2017.
 * http://www.quizful.net/testRun/Z6CDQzPoi7A2
 */
public class ListCasting {
    /* Коллекция temp не является типизированной, поэтому метод temp.add() успешно выполняется даже для объектов
    "неправильного" типа. Исключение возникнет, если при обращении к элементам коллекции ar явно или неявно будет
    выполняться преобразование к типу Integer. В данном примере такого нет, поэтому обход коллекции также выполнится
    успешно. Чтобы предотвратить добавление в коллекцию "неправильных" элементов, можно использовать представление
    с проверкой, например, такое:
    List temp = Collections.checkedList(ar, Integer.class); **/
    public static void main(String[] args) {
        try {
            ArrayList<Integer> ar = new ArrayList<Integer>();
//            List temp = ar; //1
            List temp = Collections.checkedList(ar, Integer.class);
//            temp.add(new java.util.Date()); //2
//            temp.add(new Float(1.66));
            temp.add(12);
            long l = 45L;
//            temp.add(l); // здесь тоже ошибка компиляции
            temp.add((int)l);
            Float f = new Float(1.66);
            float ff = f;
            temp.add((int)ff );
            Iterator it = ar.iterator();
            while (it.hasNext())
                System.out.println(it.next());
//            System.out.println(ar.get(0));
        } catch (Exception e) {
            System.out.println(e.getClass());
            e.printStackTrace();
        }
    }
}
