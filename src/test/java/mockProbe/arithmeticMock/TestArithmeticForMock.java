package mockProbe.arithmeticMock;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Ежище on 01.08.2016.
 */
public class TestArithmeticForMock {
    ArithmeticForMock simpleTest = new ArithmeticForMock();

    ArithmeticForMock arith = mock(ArithmeticForMock.class);

    @Test
    public void simpleSquareTest() {
        Assert.assertEquals(9, simpleTest.square(3));
    }

    @Test
    public void mockSquareTest() {
        when(arith.square(3)).thenReturn(9.0);
        Assert.assertEquals(9, arith.square(3));
    }

    @Test
    public void simpleSumTest() {
        simpleTest.a = 25;
        Assert.assertTrue(30 == simpleTest.sum(5, 5));
    }

    @Test
    public void simpleSumTest2() {
        Assert.assertTrue("sum failed", 35 == simpleTest.sum(10, 5));
    }

    @Test
    public void mockSumTest() {
        when(arith.square(5)).thenReturn(25.0);
//        simpleTest.a = arith.square(5);
//        simpleTest.a = 25;
        Assert.assertTrue(35 == arith.sum(10, 5));
    }

    @Test
    public void mockMultiplyTest() {
//        simpleTest.a = 25;
//        when(arith.sum(anyInt())).thenReturn(2);
        Assert.assertTrue(30 == simpleTest.multiply(3));
    }

}
