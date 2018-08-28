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

        Cell[] steps = new Cell[0];
        int step = 0;

        if (abs(dest.x - source.x) != abs(dest.y - source.y)) {
            throw new ImpossibleMoveException();
        }

        steps = new Cell[abs(dest.x - source.x)];
        for (Cell cell : Cell.values()) {
            if ((dest.x < cell.x && cell.x < source.x && dest.y < cell.y && cell.y < source.y) ||
                    (dest.x > cell.x && cell.x > source.x && dest.y < cell.y && cell.y < source.y) ||
                    (dest.x < cell.x && cell.x < source.x && dest.y > cell.y && cell.y > source.y) ||
                    (dest.x > cell.x && cell.x > source.x && dest.y > cell.y && cell.y > source.y))
            {
                steps[step] = cell;
                step++;
            }
        }
        steps[step] = dest;
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
