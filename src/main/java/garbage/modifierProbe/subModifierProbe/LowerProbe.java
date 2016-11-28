package garbage.modifierProbe.subModifierProbe;

import garbage.modifierProbe.HigherProbe;

/**
 * Created by Ежище on 25.11.2016.
 */
public class LowerProbe {
    static int lowerDefault;
    protected static int lowerProtected;
    public static int lowerPublic;
//    public int getLowerPublic() {return lowerPublic;}
public static void main(String[] args) {
    HigherProbe.higherPublic = 10;
//    HigherProbe.higherProtected = 10; // не-а
//    HigherProbe.higherDefault = 10; // и это нет

}

}
