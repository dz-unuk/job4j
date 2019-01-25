package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.ImpossibleMoveException;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
//        Cell[] steps = new Cell[0];
        if (source.y != dest.y + 1 || source.x != dest.x) {
            throw new ImpossibleMoveException("пешки так не ходят");
        }
//        steps = new Cell[] {dest};
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
