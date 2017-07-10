package objectMethods;

/**
 * Created by WORK_x64 on 27.06.2017.
 */
public class PrimitiveHashCode {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(Integer.valueOf(a).hashCode());
        double d = 0.89;
        System.out.println(Double.valueOf(d).hashCode());
    }
}
