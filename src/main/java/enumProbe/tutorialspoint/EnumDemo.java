package enumProbe.tutorialspoint;

/**
 * Created by Ежище on 01.04.2017.
 */
public class EnumDemo {

    public static void main(String args[]) {

        System.out.println("CellPhone List:");
        for(Mobile m : Mobile.values()) {
            System.out.println(m + " costs " + m.showPrice() + " dollars");
        }

        Mobile ret;
        ret = Mobile.valueOf(Mobile.class, "Samsung"); // но достаточно просто: ret = Mobile.valueOf("Samsung");
        System.out.println("Selected : " + ret);
    }
}
