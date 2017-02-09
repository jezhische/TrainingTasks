package collectionsAndMaps.sortProbes;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by WORK_x64 on 08.02.2017.
 */
public class ComparatorCheck {
    /* что такое ссылка на метод: для создания объекта функционального интерфейса (например, интерфейса Comparator)
     * необходимо переопределить его метод.
     * Вариант 1 - создать анонимный класс и напрямую переопределить метод.
      * Вариант 2 - создать лямбду, которая будет делать то же самое - служить заменой переопределения метода интерфейса.
      * Вариант 3 - ссылка на метод: вначале в каком-либо классе создается метод, подходящий для переопределения метода
      * интерфейса. Затем для создания объекта интерфейса просто пишется такая строчка, указывающая, что с помощью
      * этого метода нужно переопределить метод интерфейса:  объект (содержащий нужный метод) :: метод. Если метод
      * создан в том же классе, где мы на него ссылаемся, то this :: метод. Если метод статический, то
      * Имя класса :: статический метод**/

    /* функциональный интерфейс для лямбды: **/
    interface Compar {int comp (G g1, G g2);}
    /* метод для компаратора (если бы класс имплементировал Comparator, то это был бы @Override метод): **/
    public int compare (G g1, G g2) {return g1.a > g2.a? 1 : (g1.a == g2.a? 0 : -1);}
    /* создаем лямбду, чтобы использовать ее как параметр метода: **/
//    Compar comparator  = (g1, g2) -> g1.a > g2.a? 1 : (g1.a == g2.a? 0 : -1); // - можно так, но проще использовать
        // готовый метод:
    Compar comparator  = (g1, g2) -> compare(g1, g2);
    /* та же запись через ссылку на метод: **/
//    Compar comparator  = this::compare; // объект (содержащий нужный метод) :: метод, который переопределит метод
    // интерфейса для создания лямбды
    /* а если бы метод compare был static, то запись была бы такой: **/
//    Compar comparator  = ComparatorCheck::compare; // класс :: метод

    public static void main(String[] args) {
        /* создание компаратора через создание новой лямбды: **/
        TreeSet<G> tree = new TreeSet<>((g1, g2) -> g1.a > g2.a? 1 : (g1.a == g2.a? 0 : -1)); // в развернутом виде
        // это выглядит как:
        // Comparator<G> comparion = (g1, g2) -> g1.a > g2.a? 1 : (g1.a == g2.a? 0 : -1);
        // TreeSet<G> tree = new TreeSet<>
        tree.addAll(Arrays.asList(new G(239), new G(55), new G(-555)));
        for (G g : tree)
            System.out.print(g.a + ", ");
        System.out.println();

        /* создание компаратора через создание лямбды, использующей готовый метод: **/
        tree = new TreeSet<>((g1, g2) -> new ComparatorCheck().compare(g1, g2)); // в развернутом виде
        // это выглядит как:
        // Comparator<G> comparion = (g1, g2) -> new ComparatorCheck().compare(g1, g2);
        // TreeSet<G> tree = new TreeSet<>
        tree.addAll(Arrays.asList(new G(239), new G(55), new G(-555)));
        for (G g : tree)
            System.out.print(g.a + ", ");
        System.out.println();

        /* создание компаратора через создание лямбды из готовой лямбды: **/
        tree = new TreeSet<>((g1, g2) -> new ComparatorCheck().comparator.comp(g1, g2));
        tree.addAll(Arrays.asList(new G(26), new G(18), new G(-0)));
        for (G g : tree)
            System.out.print(g.a + ", ");
        System.out.println();

        /* создание компаратора через ссылку на метод: **/
        tree = new TreeSet<>(new ComparatorCheck()::compare);
        tree.addAll(Arrays.asList(new G(15), new G(5), new G(-0), new G(+0), new G(-25), new G(5)));
        for (G g : tree)
            System.out.print(g.a + ", ");
    }
}
class G {
    int a;
    G(int a) {this.a = a;}
}
