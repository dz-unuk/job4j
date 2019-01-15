package ru.job4j.tracker;

public class AddItem implements UserAction {
    private final String info;
    private final int add;

    AddItem(int key, String info) {
        this.add = key;
        this.info = info;
    }
    @Override
    public int key() {
        return this.add;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        long create = 150119L;
        Item item = new Item(name, desc, create);
        tracker.add(item);
        System.out.println("------------ New Item with Id : " + item.getId());
        System.out.println("------------ New Item with Name : " + item.getName());
        System.out.println("------------ New Item with Description : " + item.getDescription());
    }
    @Override
    public String info() {
        return String.format("%s) %s.", Long.toString(this.add), this.info);
    }
}
