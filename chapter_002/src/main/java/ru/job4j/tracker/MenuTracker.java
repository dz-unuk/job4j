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
        this.actions.add(new AddItem(0, "Add new item"));
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
    public ArrayList<Integer> keys() {
        ArrayList<Integer> arr = new ArrayList<>();
        int index = 0;
        for (UserAction action : this.actions) {
            arr.add(action.key());
        }
        return arr;
    }
}
