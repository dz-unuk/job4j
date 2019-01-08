package ru.job4j.exam;

/**
 * Слияние двух отсортированных по возрастанию массивов в один отсортированный по возрастанию.
 * Не производится проверка, что на входе массивы правильно отсортированны.
 * @author Denis
 */
public class ExamEx {
    public int[] concatSortArray(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;
        while (index1 + index2 < array1.length + array2.length) {
            if (index1 < array1.length
                    && (index2 == array2.length || array1[index1] < array2[index2])) {
                result[index1 + index2] = array1[index1];
                index1++;
            } else {
                result[index1 + index2] = array2[index2];
                index2++;
            }
        }
        return result;
    }
}
