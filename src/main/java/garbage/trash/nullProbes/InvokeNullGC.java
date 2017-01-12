package garbage.trash.nullProbes;

/**
 * Created by WORK_x64 on 12.01.2017.
 */
public class InvokeNullGC {
    public static void main(String[] args) {
        NullGC newNull = NullGC.getNullGC();
        newNull.a = 678;
        System.out.println(newNull.a);
    }
}
