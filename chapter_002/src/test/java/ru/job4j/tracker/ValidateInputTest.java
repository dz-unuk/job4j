package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Test
    public void whenInvalidInput() {
        ValidInput input = new ValidInput(
                new StubInput(new String[] {"i", "1"}),
                output
        );
        input.ask("Enter", Arrays.asList(1));
        assertThat(
                this.out.toString(),
                is(
                        String.format("Put a number, please!%n")
                )
        );
    }
    @Test
    public void whenValidInput() {
        ValidInput input = new ValidInput(
                new StubInput(new String[] {"6"}),
                output
        );
        input.ask("Enter", Arrays.asList(1));
        assertThat(
                this.out.toString(),
                is(
                        String.format("")
                )
        );
    }
}
