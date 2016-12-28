package garbage.constructor;

/**
 * Created by Ежище on 28.12.2016.
 */
public class B extends A {
    boolean boo;
    // вначале нужно создать объект класса-родителя A. Поскольку в A определен явно конструктор по умолчанию в числе
    // остальных, компилятор при создании объекта B просто создаст объект A с пустым конструктором. Можно также
    // добавить к нему новый функционал, определив новый конструктор, например:
    B (boolean boo) {
        super (); // это действие может быть не прописано: поскольку у A есть конструктор с пустыми аргуменатми, это
        // создание объекта класса-родителя совершается по умолчанию.
        boo = true;
    }
    B (boolean boo, String s) {
        super (s); // создается, фактически, объект A. Поскольку там у нас прописано, что this.s = s; и используется
        // при создании также конструктор A (int i) {} со значением i = 5, то i также будет определено.
        this.boo = boo;
    }
    B (boolean boo, boolean bee) {
        super (26, "core");
        if (!bee) // т.е. если bee = false, то !bee будет true
            this.boo = boo;
    }

    public static void main(String[] args) {
        B bb = new B(true, "shabudam");
        System.out.printf("%s.boo = %b, %s.i = %d.", bb.s, bb.boo, bb.s, bb.i);
        B boobb = new B(true, false);
        System.out.printf("\n%s.boo = %b, %s.i = %d.", boobb.s, boobb.boo, boobb.s, boobb.i);
    }

}
