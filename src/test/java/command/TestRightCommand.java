package command;

import exception.InvalidPositionException;
import models.Direction;
import models.Position;
import models.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRightCommand {
    private Command rightCommand;

    @Before
    public void setUp() {
        Robot toyRobot = new Robot();
        Position position = new Position(1, 1, Direction.NORTH);
        toyRobot.setPosition(position);
        rightCommand = new RightCommand(toyRobot);
    }

    @Test
    public void executeRight_AtInitialPosition_Should_MoveRobotToEast() throws InvalidPositionException {
        CommandResult commandResult = rightCommand.execute();
        assertEquals("Successfully moved the Toy Robot to (1, 1) facing EAST", commandResult.getMessage());
    }
}
