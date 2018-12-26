package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell ... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
               result = false;
               break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        int dimension = table.length;
        //счетчик обнаруженных фишек
        int counter = 0;

        //предполагаемое положение ряда или столбец с фишками
        int row = -1;
        int column = -1;

        //поиск производим только в нулевом ряду и столбце
        //присваивая предполагаемый ряд и столбец сможем дальше провести проверку в нем и...
        //исключаем неверное решение со всеми фишками, расположенными и в нулевом столбце, и в нулевой строке
        for (int iter = 0; iter < dimension; iter++) {
            if (table[0][iter] == 1) {
                counter++;
                if (iter != 0) column = iter;//на первом шаге проверка не нужна, только мешает
            }
            if (table[iter][0] == 1 && iter != 0) {
                counter++;
                row = iter;
            }
        }
        //поиск фишек в этом столбце/строке
        if (counter == 1){
            for (int i = 1; i < dimension; i++) counter += row > 0 ? table[row][i] : table[i][column];
        }
        //окончательная проверка, что нашли все 5, но они либо все в строке, либо все в столбце
        if (counter == 5 && (row == -1 || column == -1)) result = true;
        return result;
    }

    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}
