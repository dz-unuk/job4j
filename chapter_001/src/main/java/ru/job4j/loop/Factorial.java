package ru.job4j.loop;

public class Factorial {
    /**
     * Рассчитавает факториал числа
     * @param n целое положительное число
     * @return возвращает факториал аргумента
     */
    public int calc(int n) {
        int answer = 1;
        for (int i = 2; i <= n; i++) {
            answer *= i;
        }
        return answer;
    }
}
