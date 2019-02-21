package ru.job4j.tracker;

import java.util.ArrayList;

public class FindItemsByName extends BaseAction {
    FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Ищем заявку по Имени--------------");
        String name = input.ask("Введите имя заявки :");
        ArrayList<Item> items = tracker.findByName(name);
        if (items.size() == 0) {
            System.out.println("------------ Заявок с таким именем пока нет -----------");
        } else {
            System.out.println("------------ Заявки с таким именем: --------------");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ") " + items.get(i).toString());
            }
        }
    }
}
