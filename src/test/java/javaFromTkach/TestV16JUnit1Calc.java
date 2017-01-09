package javaFromTkach;

import javaFromTkach.javaForTester.V16JUnit.V16JUnit1Calc;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Ежище on 01.08.2016.
 */
public class TestV16JUnit1Calc {
    V16JUnit1Calc c;
    @Before // вызывается перед КАЖДЫМ ТЕСТОМ
    public void setUp() {
        c = new V16JUnit1Calc();
    }
    // @BeforeClass - перед началом ВСЕХ ТЕСТОВ

    @After // After вызывается после КАЖДОГО ТЕСТА
    public void tearDown() {
        c = null;
    }
    // @AfterClass - после ВСЕХ ТЕСТОВ.

    @Test
    public void testAdd() {
        int res = c.add(2, 5);
        // Если использовать import static junit.framework.TestCase.fail; или import static org.junit.Assert.fail;
        // , можно написать так:
//        if (7 != res) {
//            fail("Fail add");
//        }
        Assert.assertTrue("Fail add", res == 7); // сообщение будет прописано, если тест failed.
        Assert.assertEquals("Fail add (assertEquals)", 15, c.add(10, 5)); // тут вначале expected, затем actual.

    }
//    @Test
//    public void testAddMock() {
//        V16JUnit1Calc cMock = mock(V16JUnit1Calc.class);
//        when(cMock.add(3,6)).thenReturn(9);
//        Assert.assertTrue("Fail mock_add", 9 == cMock.add(3,6));
//    }
    // отлов иксепшена - первый способ:
    @Test
    public void testDiv() {
        Assert.assertTrue(c.div(5, 2) == 2);
        try {
            c.div(2, 0);
            fail("method does not throw exeption when to divide by zero");
        } catch (ArithmeticException e) {}
    }
    // отлов иксепшена - второй способ (более новый) - только для Exception:
    @Test(expected = ArithmeticException.class)
    public void testDivExcept() {
        new V16JUnit1Calc().div(2, 0); // этот метод выкинет exception, что и ожидалось.
    }
}
