import models.Direction;
import models.Position;
import org.junit.Assert;
import org.junit.Test;

public class TestPosition {

    @Test
    public void getNextPosition_ShouldIncrementYAxis_WhenDirectionNorth() {
        Position position = new Position(0, 0, Direction.NORTH);
        Position newPosition = position.getNextPosition();
        Assert.assertEquals(0, newPosition.getX());
        Assert.assertEquals(1, newPosition.getY());
        Assert.assertEquals(Direction.NORTH, newPosition.getDirection());
    }

    @Test
    public void getNextPosition_ShouldIncrementXAxis_WhenDirectionEast() {
        Position position = new Position(0, 0, Direction.EAST);
        Position newPosition = position.getNextPosition();
        Assert.assertEquals(1, newPosition.getX());
        Assert.assertEquals(0, newPosition.getY());
        Assert.assertEquals(Direction.EAST, newPosition.getDirection());
    }

    @Test
    public void getNextPosition_ShouldDecrementXAxis_WhenDirectionWest() {
        Position position = new Position(1, 0, Direction.WEST);
        Position newPosition = position.getNextPosition();
        Assert.assertEquals(0, newPosition.getX());
        Assert.assertEquals(0, newPosition.getY());
        Assert.assertEquals(Direction.WEST, newPosition.getDirection());
    }

    @Test
    public void getNextPosition_ShouldDecrementYAxis_WhenDirectionSouth() {
        Position position = new Position(1, 1, Direction.SOUTH);
        Position newPosition = position.getNextPosition();
        Assert.assertEquals(1, newPosition.getX());
        Assert.assertEquals(0, newPosition.getY());
        Assert.assertEquals(Direction.SOUTH, newPosition.getDirection());
    }
}
