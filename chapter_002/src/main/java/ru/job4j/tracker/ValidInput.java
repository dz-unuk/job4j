package ru.job4j.tracker;

import java.util.*;
import java.util.function.Consumer;

public class ValidInput implements Input {
    private final Input input;
    private final Consumer<String> output;

    public ValidInput(final Input input, final Consumer<String> output) {
        this.input = input;
        this.output = output;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean valid = false;
        int key = -1;
        do {
            try {
                key = this.input.ask(question, range);
                valid = true;
            } catch (MenuOutException moe) {
//                moe.printStackTrace();
                output.accept("Select number from a menu range");
            } catch (NumberFormatException nfe) {
                output.accept("Put a number, please!");
            }
        } while (!valid);
        return key;
    }
}