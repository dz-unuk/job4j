package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int size = data.length;
        for (int i = 0; i < size - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]) {
                result = false;
                break;
            }
            if (data[i][size - 1 - i] != data[i + 1][size - 2 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
