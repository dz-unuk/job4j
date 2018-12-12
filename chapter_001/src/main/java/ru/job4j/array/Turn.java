package ru.job4j.array;
/**
 * @author Denis
 * @version 0.1
 * @since 12.01.19
 */
public class Turn {
    public int[] back(int[] array) {
        int buffer;
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            buffer = array[length - 1 - i];
            array[length - 1 - i] = array[i];
            array[i] = buffer;
        }
        return array;
    }
}
