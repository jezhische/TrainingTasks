package garbage.trash;

import garbage.subModifierProbe.LowerProbe;

/**
 * Created by Ежище on 25.11.2016.
 */
public class HigherProbe {
    static int higherDefault;
    protected static int higherProtected;
    public static int higherPublic;

    public static void main(String[] args) {
//    LowerProbe.lowerDefault = 10; // не-а
//    LowerProbe.lowerProtected = 10; // и protected тоже
    LowerProbe.lowerPublic = 10;
    }
}
