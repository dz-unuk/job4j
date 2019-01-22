package ru.job4j.tracker;

public class FindItemsByName extends BaseAction {
    FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Ищем заявку по Имени--------------");
        String name = input.ask("Введите имя заявки :");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("------------ Заявок с таким именем пока нет -----------");
        } else {
            System.out.println("------------ Заявки с таким именем: --------------");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ") " + items[i].toString());
            }
        }
    }
}
