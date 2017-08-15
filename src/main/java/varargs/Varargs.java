package varargs;

import java.awt.*;
import java.io.PrintStream;

/**
 * Created by Ежище on 24.12.2016.
 * http://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html
 */
public class Varargs {
    // varargs - an Arbitrary Number of Arguments
    public Polygon polygonFrom(Point... corners) {
        int numberOfSides = corners.length; //  inside the method, corners is treated like an array. The method
        // can be called either with an array or with a sequence of arguments. The code in the method body will treat
        // the parameter as an array in either case.
        double squareOfSide1, lengthOfSide1;
        squareOfSide1 = (corners[1].x - corners[0].x)
                * (corners[1].x - corners[0].x)
                + (corners[1].y - corners[0].y)
                * (corners[1].y - corners[0].y);
        lengthOfSide1 = Math.sqrt(squareOfSide1);

        // more method body code follows that creates and returns a
        // polygon connecting the Points
        return null;
    }

    public PrintStream printf(String format, Object... args) {
        return null;
    }

    public static void main(String... args) {
        System.out.println("Varargs these are \"variable-length arguments\", that is Arbitrary Number of Arguments");
    }
}
