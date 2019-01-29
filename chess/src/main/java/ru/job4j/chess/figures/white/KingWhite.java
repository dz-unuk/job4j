package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.ImpossibleMoveException;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingWhite implements Figure {
    private final Cell position;

    public KingWhite(final Cell position) {
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
        if (xDist > 1 || yDist > 1 || (xDist == 0 & yDist == 0)) {
            throw new ImpossibleMoveException("король так не ходит");
        }
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
