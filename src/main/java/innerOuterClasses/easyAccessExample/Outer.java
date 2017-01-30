package innerOuterClasses.easyAccessExample;

/**
 * Created by Ежище on 29.01.2017.
 * http://ru.stackoverflow.com/questions/593480/%D0%9A%D0%B0%D0%BA-%D0%BE%D0%B1%D1%80%D0%B0%D1%89%D0%B0%D1%82%D1%8C%D1%81%D1%8F-%D0%BA-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D1%83-%D0%B2%D0%BD%D1%83%D1%82%D1%80%D0%B8-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0
 */
public class Outer {
    /*
    * рассмотрим, как можно получить доступ извне к вложенным (статическим) и внутренним (не-статическим) классам
    **/
    public static class Nested {public int a;} // вложенный (статический) класс (модификаторы доступа к классу любые)
    public class Inner {public int b;} // внутренний (не-статический) класс (модификаторы доступа к классу любые)
    private Inner inner;
    public Outer(){}
    public Outer(boolean isInner) {inner = isInner? new Inner(): null;}
    public Inner getInner() {return inner;}
}
class Test {
    public static void main(String[] args) {
        /* создание образца статического вложенного класса: **/
        Outer.Nested nested = new Outer.Nested(); // поскольку Nested статический класс, то, похоже, он рассматривается
        // как поле класса Outer
        nested.a = 25;
        System.out.println("nested.a = " + nested.a);

        /* создание образца не-статического внутреннего класса: **/
        Outer.Inner inner = new Outer().new Inner(); // не-статический Inner - это точно класс, а не поле (не объект);
        // нужно создать образец класса Inner, обратившись к классу Inner через образец класса Outer.
        inner.b = 42;
        System.out.println("inner.b = " + inner.b);

        /* еще вариант создания образца не-статического внутреннего класса: **/
        Outer.Inner elseInner = new Outer().getInner(); // так можно! но вернется null, поскольку конструктор по
        // умолчаниию НЕ ИНИЦИАЛИЗИРУЕТ поле private Inner inner класса Outer, и метод getInner() возвращает null,
        // и при попытке обратиться к полю созданного объекта elseInner получаем NullPointerException.
//        elseInner.b = 78; // - NullPointerException
        System.out.println("elseInner = " + elseInner);

        /* для этого есть специальный конструктор: **/
        Outer.Inner newElseInner = new Outer(true).getInner();
        newElseInner.b = 99;
        System.out.println("newElseInner.b = " + newElseInner.b);
    }
}
