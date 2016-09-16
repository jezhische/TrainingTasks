package InterfaceAndFabricMethods;

import static InterfaceAndFabricMethods.Inter.plus;

/**
 * Created by WORK on 16.09.2016.
 */
public class Probe implements InterInher {
    @Override
    public int divide(int a, int b) {
        return 0;
    }

    public int minus(int a, int b) {
        a = A;
        b = B;
        return a - b;
    }

    @Override
    public void print(String s) {

    }

    static Inter iint = new Inter() {
        @Override
        public int minus(int a, int b) {
            return b - a;
        }

        @Override
        public void print(String s) {

        }
    };
    public static void main(String[] args) {
//        plus(5, 6);
//        System.out.println(plus(5, 6));

        System.out.println(iint.minus(56, 46));
        Probe probe = new Probe();
        System.out.println(probe.minus(684987987, 25));
        System.out.println(plus(8, 9));
    }
}
