package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }


    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int i:range) {
            if (i == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("number is out of menu range");
        }
        return key;
    }
}
