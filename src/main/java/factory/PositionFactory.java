package factory;

import models.Direction;
import models.Position;

public class PositionFactory {

    public static Position getNextPosition(Position position, Direction direction) {
        Position newPosition = null;
        switch (direction) {
            case NORTH:
                newPosition = new Position(position.getX(), position.getY() + 1, position.getDirection());
                break;
            case SOUTH:
                newPosition = new Position(position.getX(), position.getY() - 1, position.getDirection());
                break;
            case EAST:
                newPosition = new Position(position.getX() + 1, position.getY(), position.getDirection());
                break;
            case WEST:
                newPosition = new Position(position.getX() - 1, position.getY(), position.getDirection());
                break;
        }
        return newPosition;
    }
}
