
public class SquareTableTop implements Board {
    int rows;
    int columns;

    public SquareTableTop(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    // co-ordinates can't be negative and larger than board size
    @Override
    public boolean isValidPosition(Position position) {
        return (position.getX() > this.columns || position.getX() < 0
                || position.getY() > this.rows || position.getY() < 0);
    }
}
