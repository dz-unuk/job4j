package ru.job4j.loop;

public class Counter {
    /**
     * Вычисляем сумму четных чисел между двумя аргументами.
     * @param start начальный аргумент
     * @param finish конечный аргумент
     * @return сумма четных
     */

    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
