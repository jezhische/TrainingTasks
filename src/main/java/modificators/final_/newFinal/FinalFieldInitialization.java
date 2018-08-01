package modificators.final_.newFinal;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class FinalFieldInitialization {

    public static final String string;

    static {
        try {
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            List<Driver> driverList = new ArrayList<>();
            for (; drivers.hasMoreElements(); ) driverList.add(drivers.nextElement());
            System.out.println(driverList);
            if (driverList.toString().contains("mysql")) {
                string = "string = After Exception is thrown";
                throw new Exception();
            } else string = "string = ok";
        } catch (Exception e) {
            e.printStackTrace();
// здесь ничего иного, кроме как
            throw new RuntimeException("RuntimeException in catch bloc");
        }
    }

    private static void aVoid() {}

    public static void main(String[] args) {
//        FinalFieldInitialization.aVoid();
        System.out.println(FinalFieldInitialization.string);
    }
}
