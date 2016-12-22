package heap.casting;

/**
 * Created by WORK_x64 on 22.12.2016.
 */
public class PrimitiveCasting {
    private static short f;
    private int g;

    public static void main(String[] args) {
        Short a = 34;
        Integer b = a + 5;
        Float c = a + 0.66f;
        float d = c; // или float d = c.floatValue();
        short e = (short) d;
        System.out.println(c.getClass() + " c = " + c);
        System.out.println("short e = " + e);
        PrimitiveCasting.f = (short) d;
        System.out.println(f);
        System.out.println(new PrimitiveCasting().g = (int) d);
        System.out.println(c = 7f);
    }
}
