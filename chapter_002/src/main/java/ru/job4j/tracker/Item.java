package ru.job4j.tracker;

import java.util.Objects;

public class Item {

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getCreate());
    }

    private String id;
    private String name;
    private String description;
    private long create;

    public Item() { }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public long getCreate() {
        return this.create;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String toString() {
        return this.name + " -- " + this.create + " -- " +  this.description;
        //        return this.id + " -- " + this.name + " -- " + this.create + " -- " +  this.description;
    }
}
