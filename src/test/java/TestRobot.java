import exception.InvalidPositionException;
import models.Direction;
import models.Position;
import models.Robot;
import org.junit.Assert;
import org.junit.Test;

public class TestRobot {
    @Test
    public void testBasicMovement() throws InvalidPositionException {
        Robot robot = new Robot(new Position(0, 0, Direction.NORTH));

        robot.move(robot.getPosition().getNextPosition());
        Assert.assertEquals(0, robot.getPosition().getX());
        Assert.assertEquals(1, robot.getPosition().getY());
        Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());
    }

    @Test
    public void testMovementWithRotation() throws InvalidPositionException {
        Robot robot = new Robot(new Position(0, 0, Direction.EAST));

        robot.move(robot.getPosition().getNextPosition());
        robot.move(robot.getPosition().getNextPosition());
        robot.rotateLeft();
        robot.move(robot.getPosition().getNextPosition());
        Assert.assertEquals(2, robot.getPosition().getX());
        Assert.assertEquals(1, robot.getPosition().getY());
        Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());
    }
}
