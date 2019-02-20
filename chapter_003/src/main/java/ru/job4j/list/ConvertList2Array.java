package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
//        int cells = (int) Math.ceil(list.size() / rows);
        int[][] array = new int[rows][cells];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                }
            }
        }
        return array;
    }

    /**
     * В этом методе вы должны пройтись по всем элементам
     * всех массивов в списке list и добавить их
     * в один общий лист Integer.
     * Массивы в списке list могут быть разного размера.
     * @param list список массивов
     * @return список всех элементов
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int element : array) {
                result.add(element);
            }
        }
        return result;
    }
}
