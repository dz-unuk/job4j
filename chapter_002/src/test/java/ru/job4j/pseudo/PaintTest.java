package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    private final PrintStream stdout = System.out; // ссылка на стандартный вывод в консоль
    private final ByteArrayOutputStream out = new ByteArrayOutputStream(); // буфер для хранения вывода.
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        String ln = System.lineSeparator();
        assertThat(
                new String(out.toByteArray()),
                is(String.format("+ + + +%s+ + + +%s+ + + +%s+ + + +", ln, ln, ln))
        );
    }
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        String ln = System.lineSeparator();
        assertThat(
                new String(out.toByteArray()),
                is(String.format("+ + +%s + + %s  +  ", ln, ln))
        );
    }
}