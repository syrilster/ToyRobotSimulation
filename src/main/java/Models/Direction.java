package Models;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private int directionValue;
    private static Map<Integer, Direction> directionMap = new HashMap<>();

    Direction(int direction) {
        this.directionValue = direction;
    }

    public int getDirection() {
        return directionValue;
    }

    static {
        for (Direction directionEnum : Direction.values()) {
            directionMap.put(directionEnum.directionValue, directionEnum);
        }
    }

    public Direction leftDirection() {
        return rotate(-1);
    }

    public Direction rightDirection() {
        return rotate(1);
    }

    private Direction rotate(int rotationValue) {
        int newIndex = (this.directionValue + rotationValue) < 0 ?
                directionMap.size() - 1 : (this.directionValue + rotationValue) % directionMap.size();

        return Direction.valueOf(directionMap.get(newIndex).toString());
    }

}
