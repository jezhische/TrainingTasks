package garbage.trash.trashtrash;

/**
 * Created by WORK_x64 on 26.12.2016.
 */
public class ThisProbe {
    int a;
    void ggg () {
        this.a = 5;
    }

    public static void main(String[] args) {
        ThisProbe ttt = new ThisProbe();
        System.out.println(ttt.a);
        ttt.ggg();
        System.out.println(ttt.a);

        ThisProbe mmm = new ThisProbe();
        System.out.println(mmm.a);
        mmm.ggg();
        System.out.println(mmm.a);

    }
}
