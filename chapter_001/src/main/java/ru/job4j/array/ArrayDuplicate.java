package ru.job4j.array;

import java.util.Arrays;
/**
 * @author Denis
 * @since 12.12.18
 */
public class ArrayDuplicate {
    /**
     * Удаляет дубликаты
     * @param array - строковый массив
     * @return строковый массив без дубликатов
     */
    public String[] remove(String[] array) {
        int lenght = array.length;
        for (int i = 0; i < lenght - 1; i++) {
            for (int j = lenght - 1; j > i; j--) {
                if (array[i].equals(array[j])) {
                    array[j] = array[--lenght];
                }
            }
        }
        return Arrays.copyOf(array, lenght);
    }
}
