package ru.job4j.tracker;

//import static java.lang.System.currentTimeMillis;
import java.util.*;
import java.util.Arrays;

/**
 * @version $Id$
 * @since 04.01.19
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Рандомный объект для генерации id
     */
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(this.position++, item);
        return item;
    }
    /**
     * Замена ячейки с id как в параметре, на item в параметре
     * @param id - id ячейки для замены
     * @param item - новое содержание ячейки
     * @return - удалось ли совершить замену
     */
    public boolean replace(String id, Item item) {
        item.setId(id);
        boolean result = items.indexOf(item) != -1;
        if (result) {
            items.set(items.indexOf(item), item);
        }
        return result;
    }
    /**
     *Удаляет элемент с id как в аргументе. Элементы за ним сдвигаются влево.
     * @param id - элемента для удаления
     * @return удалось ли удалить элемент
     */
    public boolean delete(String id) {
        Item item = new Item("", "", 0);
        item.setId(id);
        boolean result = items.remove(item);
        return result;
    }
    /**
     * Возвращает массив с не null элементами
     * @return Item[] - без null Item
     */
    public ArrayList<Item> findAll() {
        return this.items;
    }
    /**
     * Возвращает все элементы в виде массива, у которых имя совпадает с аргументом
     * @param name - имя
     * @return массив
     */
    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> buffer = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                buffer.add(item);
            }
        }
        return buffer;
    }
    /**
     * Возвращает элемент с полем id, полученным в качестве параметра
     * @param id - id
     * @return Item с данным id
     */
    protected Item findById(String id) {
        Item item = new Item("", "", 0);
        item.setId(id);
        boolean contain = items.indexOf(item) != -1;
        Item result = contain ? items.get(items.indexOf(item)) : null;
        return result;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(RN.nextInt() + System.currentTimeMillis());
    }
}