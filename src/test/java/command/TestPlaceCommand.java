package command;

import exception.InvalidPositionException;
import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlaceCommand {
    private Command placeCommand;

    @Before
    public void setUp() {
        Robot toyRobot = new Robot();
        Position position = new Position(1, 1, Direction.NORTH);
        toyRobot.setPosition(position);
        placeCommand = new PlaceCommand(toyRobot, position);
    }

    @Test
    public void executePlace_AtInitialPosition_Should_PlaceRobotOnBoard() throws InvalidPositionException {
        CommandResult commandResult = placeCommand.execute();
        assertEquals("Successfully placed the Toy Robot to (1, 1) facing NORTH", commandResult.getMessage());
    }
}
