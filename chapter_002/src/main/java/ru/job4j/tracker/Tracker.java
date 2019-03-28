package ru.job4j.tracker;

import java.util.*;

/**
 * @version $Id$
 * @since 04.01.19
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();
    /**
     * Указатель ячейки для новой заявки.
     */
//    private int position = 0;
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
        this.items.add(item.copyOf());
        return item;
    }
    /**
     * Замена ячейки с id как в параметре, на item в параметре
     * @param id - id ячейки для замены
     * @param item - новое содержание ячейки
     * @return - удалось ли совершить замену
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        item.setId(id);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.set(i, item.copyOf());
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     *Удаляет элемент с id как в аргументе. Элементы за ним сдвигаются влево.
     * @param id - элемента для удаления
     * @return удалось ли удалить элемент
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Возвращает массив с не null элементами
     * @return Item[] - без null Item
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>(this.items);
        return result;
    }
    /**
     * Возвращает все элементы в виде массива, у которых имя совпадает с аргументом
     * @param name - имя
     * @return массив
     */
    public List<Item> findByName(String name) {
        List<Item> buffer = new ArrayList<>();
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
        Item result = null;
        for (Item item : this.items) {
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
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