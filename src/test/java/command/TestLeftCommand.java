package command;

import exception.InvalidPositionException;
import models.Direction;
import models.Position;
import models.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLeftCommand {
    private Command leftCommand;

    @Before
    public void setUp() {
        Robot toyRobot = new Robot();
        Position position = new Position(1, 1, Direction.NORTH);
        toyRobot.setPosition(position);
        leftCommand = new LeftCommand(toyRobot);
    }

    @Test
    public void executeLeft_AtInitialPosition_Should_MoveRobotToWest() throws InvalidPositionException {
        CommandResult commandResult = leftCommand.execute();
        assertEquals("Successfully moved the Toy Robot to (1, 1) facing WEST", commandResult.getMessage());
    }
}
