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
        if (abs((source.x - dest.x)) != abs((source.y - dest.y))) {
            throw new ImpossibleMoveException("Эта фигура не может так ходить.");
        }
        Cell[] steps = new Cell[abs(source.x - dest.x)];
        int indexX = dest.x;
        int indexY = dest.y;
        int index = 0;
        int deltaX = Integer.compare(source.x, dest.x);
        int deltaY = Integer.compare(source.y, dest.y);
        while (indexX != source.x) {
            steps[index] = Cell.getCellByXY(indexX, indexY);
            indexX += deltaX;
            indexY += deltaY;
            index++;
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
