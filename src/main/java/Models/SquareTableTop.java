package Models;

import Models.Position;

public class SquareTableTop implements Board {
    private int rows;
    private int columns;

    public SquareTableTop(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    // co-ordinates can't be negative and larger than board size
    @Override
    public boolean isValidPosition(Position position) {
        return !(position.getX() > this.getColumns() || position.getX() < 0
                || position.getY() > this.getRows() || position.getY() < 0);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
