package garbage.constructor.newProbe;

public class NumericLiteral {
    public static void main(String[] args) {
        System.out.println(0x7 + " " + 0x7d + " " + 0x7dd); //
        int _a = 0x7;
        int a = 0x7d;
        int b = 0x7dd;
        double c = 0x7d;
        double d = 0x7dd;
        double e = 0x7dd.0p0;
        double f = 0x7dd.0p-3;
        double g = 0x7dd.003p-3;
        System.out.printf("%d; %d; %d; %f; %.2f; %.2f; %.7f; %.10f;  \n", _a, a, b, c, d, e, f, g);

        long h = 0x7L;
        long i = 0x7eL;
        c = 0x7d.P0;
        d = 0x7d.P0d;
        float j = 0x7d.dp-1f;
        double k = 09.0e-1d;
        double l = 09.0d;
        double m = 09d;
        double n = 09e0d;
//        double o = 09;
        System.out.printf("%d; %d; %.2f; %.2f; %.7f; %.7f; %.2f; %.2f; \n", h, i, c, d, j, k, l, m);

    }
}
