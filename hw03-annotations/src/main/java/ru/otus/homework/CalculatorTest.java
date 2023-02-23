package ru.otus.homework;

import ru.otus.homework.ggunit.annotations.After;
import ru.otus.homework.ggunit.annotations.Before;
import ru.otus.homework.ggunit.annotations.Test;

import static ru.otus.homework.ggunit.assertions.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    void addTest() {
        int a = 10;
        int b = 20;
        int expected = 30;
        int actual = calculator.add(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTest() {
        int a = 10;
        int b = 2;
        int expected = 20;
        int actual = calculator.multiply(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void failedTest() {
        throw new NullPointerException();
    }

    @After
    public void complete() {
        calculator.reset();
    }
}
