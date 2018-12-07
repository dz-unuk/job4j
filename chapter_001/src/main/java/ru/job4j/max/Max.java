package ru.job4j.max;

/**
 * @author Denis
 * @version 0.1
 * @since 07.12.2018
 */

public class Max {
    /**
     * Возвращает большее значение из двух переменных класса int
     * @param firstInt Целое число
     * @param secondInt Второе целое число
     * @return большее из введенных
     */
    public int max(int firstInt, int secondInt) {
        return firstInt > secondInt ? firstInt : secondInt;
    }
}
