package garbage.trash.testprobes;

/**
 * Created by Ежище on 14.01.2017.
 */
public class StaticBlock {
    int c;
    StaticBlock() {
        c = 67;
        System.out.println("first");
    }

    {
        c = c*2;
        System.out.println("second");
    }

    {
        int a = 8;
        a = a++;
        if (a == 9)
            System.out.println("a == 9");
        else
            System.out.println("else");
    }
//    int b = a + 5; // - ошибка компиляции

    static {
        int a = 8;
        a = ++a;
        if (a == 9)
            System.out.println("a == 9");
        else
            System.out.println("else");
    }

    static {
        System.out.println("THIRD");
    }

    public static void main(String[] args) {
        new StaticBlock();
    }
}
