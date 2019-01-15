package ru.job4j.tracker;

public class ShowItems implements UserAction {
    private final String info;
    private final int all;

    ShowItems(int key, String info) {
        this.all = key;
        this.info = info;
    }
    @Override
    public int key() {
        return all;
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

    @Override
    public String info() {
        return String.format("%s) %s.", Long.toString(this.all), this.info);
    }
}
