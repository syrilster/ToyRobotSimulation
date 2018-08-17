import models.Direction;
import models.Position;
import models.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRobot {
    @Test
    public void move_DirectionNorth_Should_IncrementYAxis() {
        Robot robot = new Robot(new Position(0, 0, Direction.NORTH));

        robot.move(robot.getPosition().getNextPosition());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getPosition().getDirection());
    }

    @Test
    public void move_DirectionEastAndRotateLeft_Should_ChangeDirectionNorth() {
        Robot robot = new Robot(new Position(0, 0, Direction.EAST));

        robot.rotateLeft();
        robot.move(robot.getPosition().getNextPosition());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getPosition().getDirection());
    }

    @Test
    public void move_DirectionEastAndRotateRight_Should_ChangeDirectionSouth() {
        Robot robot = new Robot(new Position(0, 0, Direction.EAST));

        robot.rotateRight();
        robot.move(robot.getPosition().getNextPosition());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(-1, robot.getPosition().getY());
        assertEquals(Direction.SOUTH, robot.getPosition().getDirection());
    }
}
