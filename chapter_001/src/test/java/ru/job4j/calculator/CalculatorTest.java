package ru.job4j.calculator;

import org.testng.annotations.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getresult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDiv2On2Then1() {
        Calculator calc = new Calculator();
        calc.divide(2D, 2D);
        double result = calc.getresult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSub4From2Then2() {
        Calculator calc = new Calculator();
        calc.sub(4D, 2D);
        double result = calc.getresult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiply2On2Then4() {
        Calculator calc = new Calculator();
        calc.multiply(2D, 2D);
        double result = calc.getresult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
}