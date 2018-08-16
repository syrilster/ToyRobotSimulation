package models;

import validator.PositionValidator;
import exception.InvalidPositionException;

public class SquareTableTop implements Board {
    private int rows;
    private int columns;

    public SquareTableTop(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    // co-ordinates can't be negative and larger than board size
    @Override
    public boolean isValidPosition(Position position) throws InvalidPositionException {
        return PositionValidator.isValidPosition(position, this);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
