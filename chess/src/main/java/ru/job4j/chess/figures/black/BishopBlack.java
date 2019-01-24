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
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
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
        if (Math.abs(xDist) != Math.abs(yDist) || xDist == 0) {
            throw new ImpossibleMoveException("Слоны так не ходят!");
        }
        int xDelta = xDist / Math.abs(xDist);
        int yDelta = yDist / Math.abs(yDist);
        int length = Math.abs(xDist) - 1;
        Cell[] steps = new Cell[length];
        System.out.println(dest);

        for (int index = 0; index < length; index++) {
            for (Cell cell : Cell.values()) {
                if ((cell.x == dest.x - (index + 1) * (xDelta))
                        && cell.y == dest.y - (index + 1) * (yDelta)) {
                    steps[index] = cell;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
