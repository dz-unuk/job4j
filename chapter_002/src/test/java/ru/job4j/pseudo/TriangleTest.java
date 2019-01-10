package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        String ln = System.lineSeparator();
        assertThat(
                triangle.draw(),
                is(String.format("+ + +%s + + %s  +  ", ln, ln))
        );
    }
}
