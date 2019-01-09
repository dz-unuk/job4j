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
    private final Item[] items = new Item[100];
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
        this.items[this.position++] = item;
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
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = item;
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
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                if (i != this.position - 1) {
                    System.arraycopy(this.items, i + 1, this.items, i, this.position - 1 - i);
                }
                this.items[--position] = null;
                result = true;
            }
        }
        return result;
    }
    /**
     * Возвращает массив с не null элементами
     * @return Item[] - без null Item
     */
    public Item[] findAll() {
        Item[] result = new Item[position];
        for (int index = 0; index < position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
    /**
     * Возвращает все элементы в виде массива, у которых имя совпадает с аргументом
     * @param name - имя
     * @return массив
     */
    public Item[] findByName(String name) {
        int iter = 0;
        Item[] buffer = new Item[this.position];
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                buffer[iter++] = item;
            }
        }
        Item[] result = Arrays.copyOf(buffer, iter);
        return result;
    }
    /**
     * Возвращает элемент с полем id, полученным в качестве параметра
     * @param id - id
     * @return Item с данным id
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
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