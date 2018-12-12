package ru.job4j.array;

/**
 * @author Denis
 * @version 0.1
 * @since 12.01.19
 */

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}