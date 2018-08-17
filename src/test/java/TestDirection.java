import models.Direction;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestDirection {
    private Direction direction;
    private static Map<Integer, Direction> directionMap;

    @Before
    public void setUp() {
        directionMap = new HashMap<>();
        direction = Direction.EAST;
        for (Direction directionEnum : Direction.values()) {
            directionMap.put(directionEnum.getDirectionValue(), directionEnum);
        }
    }

    @Test
    public void rotateLeft_AllDirections_ShouldRotateSuccessfully() {
        Direction direction = Direction.WEST;

        direction = direction.leftDirection();
        assertEquals(Direction.SOUTH, direction);

        direction = direction.leftDirection();
        assertEquals(Direction.EAST, direction);

        direction = direction.leftDirection();
        assertEquals(Direction.NORTH, direction);

        direction = direction.leftDirection();
        assertEquals(Direction.WEST, direction);
    }

    @Test
    public void rotateRight_AllDirections_ShouldRotateSuccessfully() {
        Direction direction = Direction.NORTH;

        direction = direction.rightDirection();
        assertEquals(Direction.EAST, direction);

        direction = direction.rightDirection();
        assertEquals(Direction.SOUTH, direction);

        direction = direction.rightDirection();
        assertEquals(Direction.WEST, direction);

        direction = direction.rightDirection();
        assertEquals(Direction.NORTH, direction);
    }

    @Test
    public void rotateShould_ReturnSouth_WhenInitialDirectionIsEast() {
        assertEquals(Direction.SOUTH, direction.rotate(5));
    }
}
