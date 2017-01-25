package heap.passingByValueOrReference;

import java.math.BigDecimal;

/**
 * Created by WORK_x64 on 25.01.2017.
 */
public class ReferenceChanging2 {
    public static void main(String[] args) {
        /* primitive: **/
        int a = 5;
        int b = 10;
        a = b;
        System.out.printf("\na = %d, b = %d", a, b);
        b = 20;
        System.out.printf("\na = %d, b = %d", a, b);
        a = 30;
        System.out.printf("\na = %d, b = %d", a, b);
        /* reference: **/
        /* immutable: **/
        BigDecimal big = new BigDecimal(12.453698746546879876546);
        BigDecimal small = new BigDecimal(0.5);
        big = small;
        System.out.printf("\nBigDecimal: big = %s, small = %s", big, small);
        small = new BigDecimal(22);
        System.out.printf("\nBigDecimal: big = %s, small = %s", big, small);
        Integer ii = 78;
        ii = 12345;
        Integer uu = 66;
        ii = uu;
        System.out.printf("\nInteger: ii = %s, uu = %s", ii, uu);
        uu = 45;
        System.out.printf("\nInteger: ii = %s, uu = %s", ii, uu);
        ii = 99;
        System.out.printf("\nInteger: ii = %s, uu = %s", ii, uu);
    }
}
