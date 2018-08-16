package utils;

import exception.InvalidCommandException;
import models.Direction;
import models.Position;
import validator.PositionValidator;
import exception.InvalidPositionException;

public class PositionUtil {
    public static Position populateInitialPosition(String placeCommandArgs) throws InvalidPositionException, InvalidCommandException {
        Position position;
        String[] placeCommandParams;
        int x;
        int y;
        Direction direction;

        placeCommandParams = placeCommandArgs.split(",");
        x = getCoOrdinate(placeCommandParams[0]);
        y = getCoOrdinate(placeCommandParams[1]);
        direction = getDirection(placeCommandParams[2]);
        position = new Position(x, y, direction);
        return position;
    }

    private static Direction getDirection(String direction) throws InvalidPositionException {
        return PositionValidator.validateAndGetDirection(direction);
    }

    private static int getCoOrdinate(String argValue) throws InvalidCommandException {
        return PositionValidator.validateAndGetCoOrdinate(argValue);
    }
}
