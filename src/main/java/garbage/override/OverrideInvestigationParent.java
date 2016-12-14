package garbage.override;

import java.util.NoSuchElementException;

/**
 * Created by WORK on 13.12.2016.
 */
public class OverrideInvestigationParent {
    protected synchronized Integer fff(int a, String s) throws NoSuchElementException, InterruptedException {
        s = "hhh";
        return (Integer) a;
    }
}
