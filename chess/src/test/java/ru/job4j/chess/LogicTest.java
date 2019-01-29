package ru.job4j.chess;
import org.junit.Test;
import ru.job4j.chess.figures.*;
import ru.job4j.chess.figures.black.BishopBlack;
import ru.job4j.chess.figures.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test(expected = OccupiedWayException.class)
    public void whenFigureOnTheWay() {
        Logic logic = new Logic();
        BishopBlack testFigure = new BishopBlack(Cell.A1);
        logic.add(testFigure);
        PawnBlack helpFigure = new PawnBlack(Cell.C3);
        logic.add(helpFigure);
        logic.move(Cell.A1, Cell.D4);
    }
    @Test(expected = ImpossibleMoveException.class)
    public void whenWrongMove() {
        Logic logic = new Logic();
        BishopBlack testFigure = new BishopBlack(Cell.A1);
        logic.add(testFigure);
        logic.move(Cell.A1, Cell.D5);
    }
    @Test(expected = FigureNotFoundException.class)
    public void whenNoFigure() {
        Logic logic = new Logic();
        BishopBlack testFigure = new BishopBlack(Cell.A1);
        logic.add(testFigure);
        logic.move(Cell.A2, Cell.D5);
    }

}
