package ru.job4j.tracker;

public class ValidInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean valid = false;
        int key = -1;
        do {
            try {
                key = super.ask(question, range);
                valid = true;
            } catch (MenuOutException moe) {
                moe.printStackTrace();
                System.out.println("Select number from a menu range");
            } catch (NumberFormatException nfe) {
                System.out.println("Put a number, please!");
            }
        } while (!valid);
        return key;
    }
}