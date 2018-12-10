package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test.
 *@author Denis Unuchak
 *@since 10.12.2018
 *@version 0.1
 */
public class BoardTest {
    /**
     *Test paint.
     */
    @Test
    public void whenThreeByThree() {
        int widthInput = 3;
        int heightInput = 3;
        String ln = System.lineSeparator();
        String expect = String.format("X X%s X %sX X%s", ln, ln, ln);
        Board board = new Board();
        String result = board.paint(widthInput, heightInput);
        assertThat(result, is(expect));
    }
    @Test
    public void whenFiveByFive() {
        int widthInput = 5;
        int heightInput = 4;
        String ln = System.lineSeparator();
        String expect = String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln);
        Board board = new Board();
        String result = board.paint(widthInput, heightInput);
        assertThat(result, is(expect));
    }
}
