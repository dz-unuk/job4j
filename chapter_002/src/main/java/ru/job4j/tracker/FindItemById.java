package ru.job4j.tracker;

public class FindItemById implements UserAction {
    private final int findId;
    private final String info;

    FindItemById(int key, String info) {
        this.findId = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.findId;
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

    @Override
    public String info() {
        return String.format("%s) %s.", Long.toString(this.findId), this.info);
    }
}
