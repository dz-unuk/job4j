package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionsTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Functions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = Functions.diapason(0, 4, x -> x * x - 2 * x + 1);
        List<Double> expected = Arrays.asList(1D, 0D, 1D, 4D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenLogFunctionThenLogResults() {
        List<Double> result = Functions.diapason(2, 5, x -> Math.log10(x));
        List<Double> expected = Arrays.asList(Math.log10(2), Math.log10(3), Math.log10(4));
        assertThat(result, is(expected));
    }
}