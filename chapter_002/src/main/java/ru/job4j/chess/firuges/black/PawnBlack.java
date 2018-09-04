package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.AnyFigure;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack extends AnyFigure {
    boolean firstMove;

    public PawnBlack(final Cell position) {
       super(position);
       this.firstMove = true;
    }

    public PawnBlack(final Cell position, boolean firstMove) {
        super(position);
        this.firstMove = firstMove;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        if (!(source.x == dest.x && ((!this.firstMove && source.y == dest.y + 1) || (this.firstMove && source.y <= dest.y + 2)))) {
            throw new ImpossibleMoveException("Эта фигура не может так ходить.");
        }
        if (!this.firstMove && source.y == dest.y + 1) {
            steps = new Cell[] {dest};
        } else if (this.firstMove && source.y <= dest.y + 2) {
            steps = new Cell[2];
            int indexY = dest.y;
            int index = 0;
            while (indexY < source.y) {
                steps[index] = Cell.getCellByXY(source.x, indexY);
                indexY++;
                index++;
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
