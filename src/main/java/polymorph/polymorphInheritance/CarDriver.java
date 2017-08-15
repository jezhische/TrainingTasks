package polymorph.polymorphInheritance;

/**
 * Created by Ежище on 18.12.2016.
 */
public class CarDriver extends BasicDriver {
    public CarDriver(int back, int forward, String driveType) {
        super(back, forward);
        this.driveType = driveType;
    }
    public CarDriver() {
        this(5, 2, "I drive car");
    }
    @Override
    public int drive() {
        return super.drive();
    }
}
