package ru.job4j.chess;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.BishopWhite;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BishopWhiteTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void whenBishopWhiteMoveUncorrect() throws FigureNotFoundException, ImpossibleMoveException {
        thrown.expect(ImpossibleMoveException.class);
        thrown.expectMessage("Эта фигура не может так ходить.");
        Logic logic = new Logic();
        logic.add(new BishopWhite(Cell.C1));
        logic.move(Cell.C1, Cell.F1);
        assertThat(logic.findBy(Cell.C1), is(0));
        assertThat(logic.findBy(Cell.F1), is(-1));
    }

    @Test
    public void whenBishopWhiteMoveCorrect() throws FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopWhite(Cell.C1));
        logic.move(Cell.C1, Cell.A3);
        assertThat(logic.findBy(Cell.C1), is(-1));
        assertThat(logic.findBy(Cell.A3), is(0));
    }

    @Test
    public void whenBishopBlackMoveUncorrect() throws FigureNotFoundException, ImpossibleMoveException {
        thrown.expect(ImpossibleMoveException.class);
        thrown.expectMessage("Эта фигура не может так ходить.");
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D7));
        logic.move(Cell.D7, Cell.F7);
        assertThat(logic.findBy(Cell.D7), is(0));
        assertThat(logic.findBy(Cell.F7), is(-1));
    }
}
