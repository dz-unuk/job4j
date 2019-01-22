package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {

    private Input input;

    private Tracker tracker;

    private List<UserAction> actions = new ArrayList<>();
    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
//        this.actions.add(new AddItem(0, "Add new item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        /*        this.actions.add(new ExitProgram(6, "Exit Program")); */
    }
    public void addAction(UserAction action) {
        this.actions.add(action);
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    public void showMenu() {
        System.out.println("Menu.");
        System.out.println("-----------------");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    /**
     * Метод возвращает массив ключей существующих действий
     */
    public int[] keys() {
        int[] arr = new int[this.actions.size()];
        int index = 0;
        for (UserAction action : this.actions) {
            arr[index++] = action.key();
        }
        return arr;
    }
/*    public class AddItem implements UserAction {
        private final String info;
        private final int key;

        AddItem(int key, String info) {
            this.key = key;
            this.info = info;
        }
        @Override
        public int key() {
            return this.key;
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
            return String.format("%s) %s.", Long.toString(this.key), this.info);
        }
    }*/
}
