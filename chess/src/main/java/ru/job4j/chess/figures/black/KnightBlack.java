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
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int xDist = Math.abs(dest.x - source.x);
        int yDist = Math.abs(dest.y - source.y);
        System.out.println(xDist);
        System.out.println(yDist);
        if (!((xDist == 1 & yDist == 2) || (xDist == 2 & yDist == 1))) {
            throw new ImpossibleMoveException("Конь так не ходит!");
        }
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
