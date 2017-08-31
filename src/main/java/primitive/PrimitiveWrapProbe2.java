package primitive;

public class PrimitiveWrapProbe2 {
    public static void main(String[] args) {
        Integer in = new Integer(5);
//        new Integer("45k"); // NumberFormatException
        in = new Integer("45");
        long l = in.longValue();
        l = in;
        in = (int)l;
        in = Integer.valueOf((int)l);

        String s = "caramba";
        String as = s;
        String asa = "caramba".intern();
        String asak = "caramba";
        String asaki = new String(s);
        String asakid = s.trim();
        System.out.println((s == as) + " " + (s == asa) + " " + (s == asak)
                + " " + (s == asaki) + " " + (s == asakid));
    }
}
