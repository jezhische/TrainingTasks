package io.IOStream.newProbes.serialization;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestTest {
    private io.IOStream.newProbes.serialization.ForTest test;
    @Before
    public void setUp() throws Exception {
        test = new io.IOStream.newProbes.serialization.ForTest(9);
    }

    @After
    public void tearDown() throws Exception {
        test = null;
    }

    @Test
    public void ret() throws Exception {
        assertEquals(test.ret(5), Integer.valueOf(50));
    }



    @Test(expected = ArithmeticException.class)  // - работает, если в классе у меня исключение не обработано
    public void exceptionCheckExpected() {
        test.exceptionCheck("0");
    }

    @Test(expected = NumberFormatException.class) // а это обработано, тест не пройдет
    public void exceptionCheckExpected2() throws Exception {
        test.exceptionCheck("si");

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void exceptionCheckExRule() throws Exception { // - работает, если в классе у меня исключение не обработано
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage(containsString("/ by zero"));
        test.exceptionCheck("0");
    }
}