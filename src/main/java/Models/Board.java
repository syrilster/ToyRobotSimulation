package Models;

public interface Board {
    int BOARD_ROWS = 5;
    int BOARD_COLUMNS = 5;
    boolean isValidPosition(Position position);
}
