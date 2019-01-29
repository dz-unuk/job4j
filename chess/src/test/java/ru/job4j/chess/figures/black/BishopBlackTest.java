package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.figures.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void whenB1E4RightPath() {
        Cell start = Cell.B1;
        Cell finish = Cell.E4;
        BishopBlack dummyBishop = new BishopBlack(start);
        Cell[] answer = {Cell.E4, Cell.D3, Cell.C2};
        assertThat(dummyBishop.way(start, finish), is(answer));
    }
}
