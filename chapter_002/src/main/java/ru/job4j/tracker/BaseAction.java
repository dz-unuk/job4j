package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    BaseAction(int key, String name){
        this.key = key;
        this.name = name;
    }
    public int key() {
        return this.key;
    }
    public String info() {
        return String.format("%s) %s.", Long.toString(this.key), this.name);
    }
}
