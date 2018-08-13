import Models.Direction;
import org.junit.Assert;
import org.junit.Test;

public class TestDirection {
    @Test
    public void testRotateLeftDirection() {
        Direction direction = Direction.WEST;

        direction = direction.leftDirection();
        Assert.assertEquals(Direction.SOUTH, direction);

        direction = direction.leftDirection();
        Assert.assertEquals(Direction.EAST, direction);

        direction = direction.leftDirection();
        Assert.assertEquals(Direction.NORTH, direction);

        direction = direction.leftDirection();
        Assert.assertEquals(Direction.WEST, direction);
    }

    @Test
    public void testRotateRightDirection() {
        Direction direction = Direction.NORTH;

        direction = direction.rightDirection();
        Assert.assertEquals(Direction.EAST, direction);

        direction = direction.rightDirection();
        Assert.assertEquals(Direction.SOUTH, direction);

        direction = direction.rightDirection();
        Assert.assertEquals(Direction.WEST, direction);

        direction = direction.rightDirection();
        Assert.assertEquals(Direction.NORTH, direction);
    }
}
