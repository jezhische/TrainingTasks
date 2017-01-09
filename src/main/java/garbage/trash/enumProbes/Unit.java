package garbage.trash.enumProbes;

/**
 * Created by WORK_x64 on 09.01.2017.
 */
public enum Unit {
    KILOMETER(1e3, "km"), METER(1, "m"), MILLIMETER(1e-3, "mm");
    double length;
    String units;
    private Unit() {}
    Unit(double length) {this.length = length;}
    Unit(double length, String units) {
        this.length = length;
        this.units = units;
    }


    public static void main(String[] args) {

    }
}
