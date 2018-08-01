package classClass.newCC;

public class CastProbe {
    public static void main(String[] args) {
        int[] iarr = {2, 3, 5};

//        byte[] barr = byte[].class.cast(iarr);
//        System.out.println(barr);


        int i = 6;
        byte b = byte.class.cast(i);
        System.out.println(b);
    }
}
