package lambda;

import java.util.Comparator;

/**
 * Created by WORK_x64 on 15.02.2017.
 */
public class ConstructorMethodReference {
    /* TODO: ПОДРОБНО СОЗДАНИЕ ЛЯМБД И ССЫЛОК НА МЕТОДЫ Я РАСПИСАЛ В: collectionsAndMaps\sortProbes\ComparatorCheck.java
    * Здесь - попытка обращения к конструктору стороннего класса как к ссылке на метод для переопределения
    * метода функционального интерфейса **/

    public ConstructorMethodReference() {}

    public interface KBuilder {
        K create(int y, int u);
    }
//    public K createK(int y, int u){return new K(y, u);}

    public static void main(String[] args) {
        /* поскольку метод, описанный в функциональном интерфейсе kBuilder, такой же точно,
        * как конструктор класса K, мы можем создать объект этого интерфейса через ссылку на конструктор класса K
        * в качестве метода: **/
        KBuilder kBuilder = K::new;
        /* Теперь конструктор класса K переопределяет метод create объекта kBuilder, и когда мы обращаемся к этому
         * методу create, мы вызываем конструктор класса K, и можем таким образом создать новый объект класса K: **/
        K a = kBuilder.create(1, 2);
        K b = kBuilder.create(1, 2);
        K c = kBuilder.create(1, 3);
        /* TODO: Чем это ценно: у класса K конструктор package-private, и из другого пакета мы его создать не сможем.
         * А вот класс ConstructorMethodReference публичный, и функциональный интерфейс KBuilder публичный, и мы
          * из любого места можем создать объект интерфейса, используя конструктор класса K для переопределения метода
          * интерфейса, и с помощью этого объекта создавать образцы класса K - смю пакет KCreatingProbe**/

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }
}
class K {
    int y, u;
    K (int y, int u) { // NB: private-package access
        this.y = y;
        this.u = u;
    }
Comparator<Integer> iii = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
};
    @Override
    public boolean equals(Object obj) {
        return obj instanceof K ? (((K) obj).y == this.y && ((K) obj).u == this.u) : super.equals(obj);
    }
}
