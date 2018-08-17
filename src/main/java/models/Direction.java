package models;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private int directionValue;
    private static Map<Integer, Direction> directionMap = new HashMap<>();

    Direction(int direction) {
        this.directionValue = direction;
    }

    static {
        for (Direction directionEnum : Direction.values()) {
            directionMap.put(directionEnum.getDirectionValue(), directionEnum);
        }
    }

    public Direction leftDirection() {
        return rotate(-1);
    }

    public Direction rightDirection() {
        return rotate(1);
    }

    public Direction rotate(int rotationValue) {
        int newIndex = (getDirectionValue() + rotationValue) < 0 ?
                getDirectionMap().size() - 1 : (getDirectionValue() + rotationValue) % getDirectionMap().size();

        return Direction.valueOf(directionMap.get(newIndex).toString());
    }

    public int getDirectionValue() {
        return directionValue;
    }

    public static Map<Integer, Direction> getDirectionMap() {
        return directionMap;
    }
}
