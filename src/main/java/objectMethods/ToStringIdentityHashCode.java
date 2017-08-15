package objectMethods;

/**
 * Created by WORK_x64 on 26.01.2017.
 */
public class ToStringIdentityHashCode {
    public static void main(String[] args) {
        System.out.println(new ToStringIdentityHashCode().toString());
        System.out.println(new ToStringIdentityHashCode().toString());
        System.out.println(System.identityHashCode(new ToStringIdentityHashCode()));
        System.out.println(new ToStringIdentityHashCode().getClass());
        System.out.println(ToStringIdentityHashCode.class);
        System.out.println();

        ToStringIdentityHashCode to = new ToStringIdentityHashCode();
        System.out.println(to.toString());
        System.out.println(to.hashCode());
        System.out.println(System.identityHashCode(to));
        System.out.println(0x3cd1a2f1 == 1020371697);
        System.out.println(Integer.toHexString(1020371697) + " = " + Integer.toString(0x3cd1a2f1) + ", " +
                Integer.valueOf(Integer.toString(0x3cd1a2f1)));
    }
}
