package command;

import exception.InvalidPositionException;
import factory.CommandFactory;
import models.Direction;
import models.Position;
import models.Robot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRightCommand {
    private Command rightCommand;
    private Robot toyRobot;
    private CommandResult commandResult;

    @Before
    public void setUp() {
        toyRobot = new Robot();
        Position position = new Position(1, 1, Direction.NORTH);
        toyRobot.setPosition(position);
        rightCommand = new RightCommand(toyRobot);
    }

    @Test
    public void executeRight_AtInitialPosition_Should_MoveRobotToEast() throws InvalidPositionException {
        commandResult = rightCommand.execute();
        Assert.assertEquals("Successfully moved the Toy Robot to (1, 1) facing EAST", commandResult.getMessage());
    }
}
