package ru.job4j.tracker;

public class ShowItems extends BaseAction {
    ShowItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] list = tracker.findAll();
        if (list.length == 0) {
            System.out.println("------------ Заявок пока нет -----------");
        } else {
            System.out.println("------------ Заполненные заявки: --------------");
            for (int i = 0; i < list.length; i++) {
                System.out.println((i + 1) + ") " + list[i].toString());
            }
        }
    }
}
