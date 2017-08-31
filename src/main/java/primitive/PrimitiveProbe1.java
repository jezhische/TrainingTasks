package primitive;

public class PrimitiveProbe1 {
    public static void main(String[] args) {
        int i = 1;
        byte b = 1;
        String value = "1000";
        Integer iObj = new Integer(i);
        Byte bObj = new Byte(b);
        System.out.println("while i==b is " +
                (i==b));
        System.out.println("iObj.equals(bObj) is "
                + iObj.equals(bObj));
        Long lObj = new Long(value);
        System.out.println("lObj = " +
                lObj.toString());
        Long sum = new Long(lObj.longValue() +
                iObj.byteValue() +
                bObj.shortValue());
        System.out.println("The sum = " +
                sum.doubleValue());
    }
}
