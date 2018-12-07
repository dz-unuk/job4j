package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenZero() {
        Factorial factorial = new Factorial();
        int input = 0;
        int expectedOutput = 1;
        int result = factorial.calc(input);
        assertThat(result, is(expectedOutput));
    }
    @Test
    public void whenFive() {
        Factorial factorial = new Factorial();
        int input = 5;
        int expectedOutput = 120;
        int result = factorial.calc(input);
        assertThat(result, is(expectedOutput));
    }
}
