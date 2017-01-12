package garbage.trash.nullProbes;

/**
 * Created by WORK_x64 on 12.01.2017.
 */
public class NullGC {
    public int a;
    private NullGC(int a) {this.a = a;}
//    NullGC () {}

    private static final NullGC eternity = new NullGC(45);
    public static NullGC getNullGC () {return eternity;}


    public static void main(String[] args) {

//        NullGC n = new NullGC(5);
//        System.out.println(n.a);
//        System.out.println(n);
//        n = null;
//        System.out.println(n);
//        n = new NullGC(5);
//        System.out.println(n);

//        NullGC m = new NullGC();
//        System.out.println(m.eternity.a);


//        ArrayList<NullGC> nnn = new ArrayList<>();
//        nnn.add(n);
//        System.out.println(nnn.get(0));

    }
}
