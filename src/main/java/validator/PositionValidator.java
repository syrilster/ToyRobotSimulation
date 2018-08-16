package validator;

import exception.InvalidCommandException;
import exception.InvalidPositionException;
import models.Direction;
import models.Position;
import models.SquareTableTop;

import java.util.Optional;

import static exception.ExceptionConstants.*;

public class PositionValidator {

    public static boolean isValidPosition(Position position, SquareTableTop board) throws InvalidPositionException {
        if (position == null) {
            throw new InvalidPositionException(TOY_ROBOT_NOT_PLACED_ON_BOARD);
        } else if ((position.getX() > board.getColumns() || position.getX() < 0
                || position.getY() > board.getRows() || position.getY() < 0)) {
            throw new InvalidPositionException(TOY_ROBOT_PLACED_OUTSIDE);
        }
        return true;
    }

    public static Direction validateAndGetDirection(String directionValue) throws InvalidPositionException {
        Optional<Direction> direction = Direction.getDirectionMap().values()
                .stream()
                .filter(e -> e.toString().equalsIgnoreCase(directionValue))
                .findFirst();
        if (!direction.isPresent()) {
            throw new InvalidPositionException(INVALID_DIRECTION_COMMAND);
        }
        return direction.get();
    }

    public static int validateAndGetCoOrdinate(String value) throws InvalidCommandException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new InvalidCommandException(INCOMPLETE_COMMAND_ARGUMENTS);
        }
    }
}
