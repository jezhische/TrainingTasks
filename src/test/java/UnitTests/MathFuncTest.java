package UnitTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import testingUnitsFromNet.MathFunc;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Ежище on 13.07.2016.
 */
public class MathFuncTest {
    private MathFunc math;

    @Before
    public void init() { math = new MathFunc(); } // создали объект класса, конструктор с нулевыми аргументами
    @After
    public void tearDown() { math = null; } // обнулили объект - он обнулится после тестов

    @Test
    public void calls() { // создание тестового метода для проверки изменения переменной calls
        assertEquals(0, math.getCalls()); // метод assertEquals: утверждаем, что изначально она равна нулю

        math.factorial(1);
        assertEquals(1, math.getCalls()); // утверждаем, что теперь, после вызова метода factorial, она стала равной 1

        math.factorial(1);
        assertEquals(2, math.getCalls()); // вызвали factorial еще раз - стала 2
    }

    @Test
    public void factorial() { // здесь проверяем правильность вычислений для нескольких аргументов
        assertTrue(math.factorial(0) == 1); // NOTE: в аргументе метода assertTrue - boolean выражение
        assertTrue(math.factorial(1) == 1);
        assertTrue(math.factorial(5) == 120);
    }

    @Test(expected = IllegalArgumentException.class) // NOTE: параметр аннотации expected - указание, какое исключение
    // будет сгенерировано методом при подстановке иллегального аргумента
    public void factorialNegative() { // здесь проверяем, что метод factorial создает соотв. Exception
        math.factorial(-1);
    }

    @Ignore
    @Test
    public void todo() {
        assertTrue(math.plus(1, 1) == 3);
    }
//    public static void main(String[] args) throws Exception {
//        JUnitCore runner = new JUnitCore();
//        Result result = runner.run(MathFuncTest.class);
//        System.out.println("run tests: " + result.getRunCount());
//        System.out.println("failed tests: " + result.getFailureCount());
//        System.out.println("ignored tests: " + result.getIgnoreCount());
//        System.out.println("success: " + result.wasSuccessful());
//    }
}
