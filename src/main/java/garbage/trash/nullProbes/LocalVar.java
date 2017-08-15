package garbage.trash.nullProbes;

/**
 * Created by WORK_x64 on 12.01.2017.
 */
public class LocalVar {
    static int var;
    static  Object obj;

    public static void main(String[] args) {
        System.out.println(obj);
        System.out.println(var + " " + obj);

        Object object;
        int i;
        String s = new String();
        System.out.println(s);
    }
}
