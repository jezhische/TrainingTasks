package garbage.trash.enumProbes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;

import static garbage.trash.enumProbes.Unit.KILOMETER;
import static garbage.trash.enumProbes.Unit.METER;
import static garbage.trash.enumProbes.Unit.MILLIMETER;

/**
 * Created by WORK_x64 on 09.01.2017.
 */
public class UnitUtil {
    public static void shiftUnits(PrintStream out) {
        for (Unit u1: Unit.values())
            for (Unit u2: Unit.values())
                out.println(String.format("There are %.6f %s in one %s", u2.length / u1.length, u1.units,u2.units));
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(KILOMETER.name());
        System.out.println(MILLIMETER.ordinal());
        System.out.println(KILOMETER.length);
        System.out.printf("path length = %.3f%s\n", MILLIMETER.length, MILLIMETER.units);

        shiftUnits(System.out);
        File file = new File("src//main//java//garbage//trash//enumProbes//UnitUtilOut.txt");
        shiftUnits(new PrintStream(file));
        System.out.println(Arrays.toString(Unit.values()));
    }


}
