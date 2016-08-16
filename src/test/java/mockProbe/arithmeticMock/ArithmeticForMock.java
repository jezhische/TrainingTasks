package mockProbe.arithmeticMock;

/**
 * Created by Ежище on 01.08.2016.
 */
public class ArithmeticForMock {
    public int a;

    public double square(double b){
//        b = (int)Math.pow(b, 2);
        return b;
    }

    public double sum(double c, int b) {
        c = c + square(b);
        return c;
    }

    public double multiply(double d) {
//        d = d*sum(10);
        return d;
    }
}
