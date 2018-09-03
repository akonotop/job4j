package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

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
        if (Math.abs(dest.y - source.y) != Math.abs(dest.x - source.x)) {
            throw new ImpossibleMoveException("Так ходить нельзя.");
        }
        int numSteps = Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[numSteps];
        int x = source.x;
        int y = source.y;
        int dy = dest.y > source.y ? 1 : -1;
        int dx = dest.x > source.x ? 1 : -1;
        for (int i = 0; i < numSteps; i++) {
            x += dx;
            y += dy;
            steps[i] = Cell.valueOf(x, y);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
