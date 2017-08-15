package garbage.trash.testprobes;

/**
 * Created by Ежище on 14.01.2017.
 */
public class StaticBlockOneMore {
    int a, b;
    static int c;
    int d, e;
    StaticBlockOneMore(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    {b = 1; e = 33333;}
    static {c = 5;}

    public static void main(String[] args) {
        StaticBlockOneMore sbom = new StaticBlockOneMore(10, 100, 1000);
        System.out.println(String.format("a = %d, b = %d, c = %d, d = %d, e = %d", sbom.a, sbom.b, c, sbom.d, sbom.e));
    }
}
