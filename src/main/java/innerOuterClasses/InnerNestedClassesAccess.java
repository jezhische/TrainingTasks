package innerOuterClasses;

/**
 * Created by Ежище on 22.12.2016.
 */
public class InnerNestedClassesAccess {
    private int go(int start) {
        this.go(45);
        return 0;}
    private int a, b;
    private static int stat;

    static class Nested { // любые модификаторы доступа: private etc.
        static {
            stat = 5;
        }
        InnerNestedClassesAccess inca = new InnerNestedClassesAccess();
        {inca.a = 12;
        new InnerNestedClassesAccess().b = 23;}
        void rrr() {
            inca.go(3);
        }
    }

    class Inner { // любые модификаторы доступа: private etc.
        { // но не static блок!
            stat = 5;
        }
        {a = 45;
        InnerNestedClassesAccess.this.b = 56;
        InnerNestedClassesAccess.this.a = 3;}

        InnerNestedClassesAccess g = InnerNestedClassesAccess.this;

        void rrr() {
            go(3);
            InnerNestedClassesAccess.this.go(88);
            g.go(789);
        }
    }
}
