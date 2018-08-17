package models;

import exception.InvalidPositionException;

public interface Board {
    int BOARD_ROWS = 4;
    int BOARD_COLUMNS = 4;
    boolean isValidPosition(Position position) throws InvalidPositionException;
}
