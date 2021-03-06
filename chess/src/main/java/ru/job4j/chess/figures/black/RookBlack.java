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
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int xDist = dest.x - source.x;
        int yDist = dest.y - source.y;
        if ((xDist != 0 & yDist != 0) || (xDist == 0 & yDist == 0)) {
            throw new ImpossibleMoveException("Ладья так не ходит!");
        }
        int xDelta = xDist != 0 ? xDist / Math.abs(xDist) : 0;
        int yDelta = yDist != 0 ? yDist / Math.abs(yDist) : 0;
        int length = Math.abs(xDist + yDist);

        Cell[] steps = new Cell[length];
        Cell[] board = Cell.values();

        for (int index = 0; index < length; index++) {
            steps[index] = board[8 * dest.x + dest.y
                    - 8 * xDelta * index - yDelta * index];
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
