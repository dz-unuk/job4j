package ru.job4j.array;

/**
 * @author Denis
 * @since 12.12.18
 */
public class BubbleSort {
    /**
     * Сортировка пузырьком
     * @param array массив int на вход
     * @return отсортированный массив int на выход
     */
    public int[] sort(int[] array) {
        int buffer;
        int lenght = array.length;
        for (int i = 0; i < lenght - 1; i++) {
            for (int j = 0; j < lenght - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
        }
        return array;
    }
}
