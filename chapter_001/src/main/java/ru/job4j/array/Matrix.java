package ru.job4j.array;
/**
 * @author Denis
 * @since 12.12.18
 */
public class Matrix {
    /**
     * Создаем таблицу умножения
     * @param size - размер таблицы
     * @return двумерный массив с таблицей
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
