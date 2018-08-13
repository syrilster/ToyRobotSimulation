import Models.Direction;
import Models.Position;
import Exception.GameException;
import org.junit.Assert;
import org.junit.Test;

public class TestPosition {

    @Test
    public void testGetNextPositionBasicTestOne() throws GameException {
        Position position = new Position(0, 0, Direction.NORTH);
        Position newPosition = position.getNextPosition();
        Assert.assertEquals(0, newPosition.getX());
        Assert.assertEquals(1, newPosition.getY());
        Assert.assertEquals(Direction.NORTH, newPosition.getDirection());
    }

    @Test
    public void testGetNextPositionBasicTestTwo() throws GameException {
        Position position = new Position(0, 0, Direction.EAST);
        Position newPosition = position.getNextPosition();
        Assert.assertEquals(1, newPosition.getX());
        Assert.assertEquals(0, newPosition.getY());
        Assert.assertEquals(Direction.EAST, newPosition.getDirection());
    }
}
