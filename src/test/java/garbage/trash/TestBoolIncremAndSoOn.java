package garbage.trash;

import garbage.trash.BoolIncremAndSoOn;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Ежище on 19.02.2017.
 */
public class TestBoolIncremAndSoOn {
    BoolIncremAndSoOn bool;

//    public static void main(String[] args) {
//        int a = 0;
//        System.out.println((a++ == a++) + ", " + a); // false, 2 ???(здесь 0 == 1, т.е. вначале a ==, затем a++,
//        // - получается (a = 0) == (a = 1))???
//        System.out.println((++a == a++) + ", " + a); // true, 4 (3 == 3)
//        System.out.println((++a == ++a) + ", " + a); // false, 6 (5 == 6)
//    }
    @Before
    public void init() {bool = new BoolIncremAndSoOn();}
    @After
    public void tearDown() {bool = null;}
    @Test
            public void increm() {
        Assert.assertFalse(bool.postfix(0));
    }

}
