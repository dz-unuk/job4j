package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtOneMinusThreeThenMinusTwo() {
        Calculator calc = new Calculator();
        calc.subtract(1D, 3D);
        double result = calc.getResult();
        double expected = -2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivSixByTwoThenThree() {
        Calculator calc = new Calculator();
        calc.div(6D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultSixAndTwoThenTwelve() {
        Calculator calc = new Calculator();
        calc.multiply(6D, 2D);
        double result = calc.getResult();
        double expected = 12D;
        assertThat(result, is(expected));
    }
}
