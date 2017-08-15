package garbage.trash;

/**
 * Created by Ежище on 19.02.2017.
 */
public class BitShift {
    public static void main(String[] args) {
        System.out.println(0xf1); // f = 15; 15*16 + 1 = 241
//        for(int i = 0; i < 30; i++)
//            System.out.print(Integer.toHexString((i * 10 + 1)) + ", ");
        System.out.println("0b10000001 = " + 0b10000001 + " /"  + Integer.toBinaryString(0b10000001));
        System.out.println("-0b10000001 = " + -0b10000001 + " /"  + Integer.toBinaryString(0b10000001));
        System.out.println("0b10000001 >> 1 = " + (0b10000001 >> 1) + " /"  + Integer.toBinaryString((0b10000001 >> 1)));
        System.out.println("0b10000001 >>> 1 = " + (0b10000001 >>> 1) + " /"  + Integer.toBinaryString((0b10000001 >>> 1)));

        System.out.println();
        System.out.println("-0b10000001 = /" + Integer.toBinaryString(-0b10000001));
        System.out.println("-0b10000001 >> 5 = " + (-0b10000001 >> 5) + " /"  + Integer.toBinaryString((-0b10000001 >> 5)));
        /* здесь высшие биты, которые сейчас забиты единицами, забиваются при сдвиге нулями: **/
        System.out.println("-0b10000001 >>> 5 = " + (-0b10000001 >>> 5) + " /"  + Integer.toBinaryString((-0b10000001 >>> 5)));
        System.out.println(0b11111111111111111111111111111111);
        System.out.println(0b11111111111111111111111111111111>>>1);
        System.out.println(0b01111111111111111111111111111111);
        System.out.println(0b01111111111111111111111111111111>>>1);
        System.out.println(0b00111111111111111111111111111111);
        System.out.println(0b00111111111111111111111111111111>>>3);
        System.out.println(0b00000111111111111111111111111111);
        System.out.println(0b00000111111111111111111111111111>>>31);
        System.out.println((0b11111111111111111111111111111111>>>32) + " /"  + Integer.toBinaryString((
                0b11111111111111111111111111111111 >>> 32)));
        System.out.println((0b11111111111111111111111111111111>>>33) + " /"  + Integer.toBinaryString((
                0b11111111111111111111111111111111 >>> 33)));
        System.out.println((0b10000000000000000000000000000001<<1) + " /0b10000000000000000000000000000001<<1: "  +
                Integer.toBinaryString((0b10000000000000000000000000000001<<1)));

        System.out.println();
        System.out.println(1 | 4);
        System.out.println(1 ^ 4);
        System.out.println(1 & 4);
        System.out.println(~4);

        System.out.println();
        System.out.println(10>>1);
        System.out.println(11>>1);
        System.out.println(9>>1);
    }
}
