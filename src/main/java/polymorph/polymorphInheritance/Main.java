package polymorph.polymorphInheritance;

/**
 * Created by Ежище on 18.12.2016.
 */
public class Main {
    public static int go (BasicDriver basicDriver) {
        return basicDriver.drive();
    }
    public static void main(String[] args) {
        CarDriver carDriver = new CarDriver(5, 2, "I drive car");
        TruckDriver truckDriver = new TruckDriver(5, 2, "I drive truck");
        System.out.println(carDriver.driveType + ": " + go(carDriver));
        System.out.println(truckDriver.driveType + ": " + go(truckDriver));
    }
}
