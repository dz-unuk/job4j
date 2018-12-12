package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSend51273Then12357() {
        BubbleSort bsort = new BubbleSort();
        int[] input = new int[] {5, 1, 2, 7, 3};
        int[] rst = bsort.sort(input);
        int[] expect = new int[] {1, 2, 3, 5, 7};
        assertThat(rst, is(expect));
    }
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bsort = new BubbleSort();
        int[] input = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] rst = bsort.sort(input);
        int[] expect = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(rst, is(expect));
    }
}
