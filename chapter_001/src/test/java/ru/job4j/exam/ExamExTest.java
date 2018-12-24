package ru.job4j.exam;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ExamExTest {
    @Test
    public void whenChekConcat1() {
        ExamEx check = new ExamEx();
        int[] input1 = new int[]{1, 3, 5, 7, 9, 13};
        int[] input2 = new int[]{2, 4, 6, 8, 10, 11};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13};
        int[] result = check.concatSortArray(input1, input2);
        assertThat(result, is(expected));
    }
    @Test
    public void whenChekConcat2() {
        ExamEx check = new ExamEx();
        int[] input1 = new int[]{1, 3, 5, 7, 9, 11};
        int[] input2 = new int[]{2, 4, 6, 8, 10, 12};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] result = check.concatSortArray(input1, input2);
        assertThat(result, is(expected));
    }
}
