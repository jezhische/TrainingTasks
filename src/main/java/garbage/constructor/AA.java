package garbage.constructor;

/**
 * Created by WORK_x64 on 28.12.2016.
 */
public class AA {
    String s;
    int i;
    boolean boo;
    AA (String s) {
        this.s = s;
    }
    AA () {}
//    AA(boolean boo) {
//        this ();
//        this.boo = boo;
//        this.s = s + s;
//    }
//    AA (int i) {
//        this (true);
//        this.i = i;
//    }

    public static void main(String[] args) {
//        AA fff = new AA(4);
//        System.out.println(fff.s + fff.i + fff.boo);
    }
}
