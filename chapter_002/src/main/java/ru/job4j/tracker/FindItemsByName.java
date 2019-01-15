package ru.job4j.tracker;

public class FindItemsByName implements UserAction {
    private final int findName;
    private final String info;

    FindItemsByName(int key, String info) {
        this.findName = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.findName;
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

    @Override
    public String info() {
        return String.format("%s) %s.", Long.toString(this.findName), this.info);
    }
}
