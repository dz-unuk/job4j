package ru.job4j.tracker;

public class FindItemById extends BaseAction {
    FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Ищем заявку по id--------------");
        String id = input.ask("Введите id заявки :");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("------------ Заявки с таким ID не существует -----------");
        } else {
            System.out.println("------------ Вот она: --------------");
            System.out.println(item.toString());
        }
    }
}
