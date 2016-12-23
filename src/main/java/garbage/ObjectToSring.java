package garbage;

/**
 * Created by WORK_x64 on 23.12.2016.
 */
public class ObjectToSring {

    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj);
        System.out.println(obj.hashCode());
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getName());
        obj = "hhh";
        System.out.println(obj);
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getName());

    }
}
