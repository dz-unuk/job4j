package ru.job4j.comparator;

import java.util.Comparator;

public class StringsCompare implements Comparator<String> {
    /**
     * Необходимо реализовать поэлементное сравнение двух списков,
     * т.е. сравниваем элементы двух списков, находящихся на одних и тех же позициях
     * (по одним и тем же индексом). Сравнение в лексикографическом порядке.
     *
     * В этом задании нельзя использовать метод String.compateTo.
     *
     * Вы можете использовать:
     * String.charAt(int index)
     * Integer.compare(int left, int right),
     * Character.compare(char left, char right);
     *
     * @param left первая строка
     * @param right вторая строка
     * @return отрицательное, если левое меньше правого; положительное, если наоборот; ноль, если равны
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int characters = Math.min(right.length(), left.length());
        int iter = 0;
        while (result == 0 && iter < characters) {
            result = Character.compare(left.charAt(iter), right.charAt(iter));
            iter++;
        }
        if (result == 0) {
            result = left.length() - right.length();
        }
        return result;
    }
}