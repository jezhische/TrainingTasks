package garbage.constructor;

/**
 * Created by Ежище on 28.12.2016.
 */
public class A {
    int i;
    String s;
    public A() {} // конструктор - это основной метод создания объекта класса, это функция, по которой создается объект.
    A(int i) {
        this(); // можно вначале создать объект с помощью уже определенного конструктора, а затем добавить к нему новый
        // функционал - похоже на наследование, где вначале создаем родителя, а затем можем добавить к нему новую логику.
        this.i = i;
    }
    A (int i, String s) {
        this(i);
        this.s = s;
    }
    A (String s) {
        this(5); // можно также воспользоваться конструктором A(int i) {}, но поскольку в параметрах данного
        // конструктора переменной i нет, то нужно сразу создавать конструктор с определенным значением
        this.s = s;
    }

    public static void main(String[] args) {
        A aa = new A("hsh'");
        System.out.printf("%s.i = %d;%10.2f",aa.s, aa.i, 23.2968);
    }
}