package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.ImpossibleMoveException;

public class Board {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
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
    private void figureHere(Cell cell) throws FigureNotFoundException {
        if (findBy(cell) == -1) {
            throw new FigureNotFoundException("здесь нет фигуры");
        }
    }
    private void freePath(Cell[] cells) {
        for (Cell c : cells) {
            if (findBy(c) == -1) {
                throw new OccupiedWayException("путь занят");
            }
        }
    }
    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        try {
            figureHere(source);
            Cell[] steps = this.figures[index].way(source, dest);
            freePath(steps);
            if (steps[0].equals(dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        } catch (ImpossibleMoveException ime) {
            System.out.println("переходите!");
        } catch (OccupiedWayException owe) {
            System.out.println("путь занят!");
        } catch (FigureNotFoundException fnfe) {
            System.out.println("нет фигуры");
        }
        return rst;
    }
}
