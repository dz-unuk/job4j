package ru.job4j.array;
/**
 * @author Denis
 * @version 0.1
 * @since 12.01.19
 */
public class Check {
    /**
     * Возвращает true, если все элементы булевого массива одинаковы. Иначе false.
     * @param data - массив булевых переменных
     * @return boolean
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
