package ru.job4j.tracker;

import java.util.List;

public class ShowItems extends BaseAction {
    ShowItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        List<Item> list = tracker.findAll();
        if (list.size() == 0) {
            System.out.println("------------ Заявок пока нет -----------");
        } else {
            System.out.println("------------ Заполненные заявки: --------------");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ") " + list.get(i).toString());
            }
        }
    }
}
