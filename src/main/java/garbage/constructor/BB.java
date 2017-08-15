package garbage.constructor;

/**
 * Created by WORK_x64 on 28.12.2016.
 */
public class BB extends AA {
    Integer x;
    BB (Integer x) {
        super ("ggg");
        this.x = x;
    }
    BB (boolean k, boolean l) {
        this ("hhh", true);
    }
    BB (String s, boolean boo) {
        super (s);
        this.boo = boo;
    }

}
