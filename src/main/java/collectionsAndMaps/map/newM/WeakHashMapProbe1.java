package collectionsAndMaps.map.newM;

import java.util.Map;
import java.util.WeakHashMap;

//http://www.quizful.net/question/R8HQemisvZG9
public class WeakHashMapProbe1 {
//    WeakHashMap, фактически, хранит не пары "ключ - значение", а пары "слабая ссылка на ключ - значение".
// Особенность слабых ссылок (WeakReference) состоит в том, что они игнорируются сборщиком мусора, т.е. если
// на объект-ключ нет других ссылок, он уничтожается.
    public static void main(String[] args) {
        Map map = new WeakHashMap();
        Object obj = new Object(); // создаём объект
        map.put(obj, "object"); // кладём его в мапу
        System.out.println(map.size()); // в мапе один элемент
        obj = null; // чистим ссылку
//        Сборка мусора - затратная по ресурсам операция, и обычно она выполняется по мере необходимости.
// А в "малюсенькой" программе эта необходимость может и не возникнуть. Для этого нужно более активно поработать
// с памятью, например, хотя бы так:
        for(int i=0; i<1000; i++) { byte b[] = new byte[1000000]; b = null; }

//        Или можно попробовать так - тоже работает:
//        System.gc(); // играемся со сборщиком мусора
//        System.runFinalization();
        System.out.println(map.size()); // мапа должна стать пустой
    }
}
