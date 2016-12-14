package garbage.override;

import java.util.NoSuchElementException;

/**
 * Created by WORK on 13.12.2016.
 */
public class OverrideInvestigationInheritor extends OverrideInvestigationParent {
    @Override
    public Integer fff(int aui, String ghj) throws NoSuchElementException {
        ghj = String.valueOf(aui);
        return (Integer) aui;
    }

    public Integer fff(String ghj, double r) {
        Integer trew = new Integer(6);
        System.out.print(ghj + r);
        return trew;
    }

public static void main(String[] args) {
    new OverrideInvestigationInheritor().fff(5, "f");
    new OverrideInvestigationInheritor().fff("g", 78);
    try {
        new OverrideInvestigationParent().fff(5, "ui");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("");
    System.out.println(new OverrideInvestigationInheritor().fff("g", 78));

//    System.out.println(new OverrideInvestigationInheritor().fff());
}
}
