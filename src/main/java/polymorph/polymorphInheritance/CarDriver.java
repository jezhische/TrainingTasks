package polymorph.polymorphInheritance;

/**
 * Created by Ежище on 18.12.2016.
 */
public class CarDriver extends BasicDriver {
    public CarDriver(int back, int forward, String driveType) {
        super(back, forward);
        this.driveType = driveType;
    }
    @Override
    public int drive() {
        return super.drive();
    }
}
