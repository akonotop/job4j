package ru.job4j.chess.firuges;

public abstract class AnyFigure implements Figure {

    private final Cell position;

    public AnyFigure(final Cell position) {
        this.position = position;
    }
    @Override
    public Cell position() {
        return this.position;
    }
}
