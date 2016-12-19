package polymorph.polymorphInheritance;

/**
 * Created by Ежище on 18.12.2016.
 */
public class BasicDriver {
    public int back, forward;
    public String driveType;
    public BasicDriver(int back, int forward) {
        this.back = back;
        this.forward = forward;
    }
    public int drive() {
        return back + forward;
    }
}
