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
     * @param left
     * @param right
     * @return
     */
    @Override
    public int compare(String left, String right) {
        return 0;
    }
}