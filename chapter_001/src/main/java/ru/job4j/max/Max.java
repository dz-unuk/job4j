package ru.job4j.max;

/**
 * @author Denis
 * @version 0.1
 * @since 07.12.2018
 */

public class Max {
    /**
     * Возвращает большее значение из двух переменных класса int
     * @param first Целое число
     * @param second Второе целое число
     * @return большее из аргументов
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * Возвращает большее значение из двух переменных класса int
     * @param first Целое число
     * @param second Второе целое число
     * @param third Третье целое число
     * @return большее из аргументов
     */
    public int max(int first, int second, int third) {
        return this.max(first, this.max(second, third));
    }
}
