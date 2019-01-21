package ru.job4j.tracker;

public class ValidInput implements Input {
    private final Input input;

    public ValidInput(final Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean valid = false;
        int key = -1;
        do {
            try {
                key = this.input.ask(question, range);
                valid = true;
            } catch (MenuOutException moe) {
//                moe.printStackTrace();
                System.out.println("Select number from a menu range");
            } catch (NumberFormatException nfe) {
                System.out.println("Put a number, please!");
            }
        } while (!valid);
        return key;
    }
}