package command;

import exception.InvalidPositionException;
import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMoveCommand {
    private Command moveCommand;

    @Before
    public void setUp() {
        Robot toyRobot = new Robot();
        Position position = new Position(1, 1, Direction.NORTH);
        SquareTableTop squareTableTop = new SquareTableTop(Board.BOARD_ROWS, Board.BOARD_COLUMNS);
        toyRobot.setPosition(position);
        moveCommand = new MoveCommand(toyRobot, squareTableTop);
    }

    @Test
    public void executeMove_AtInitialPosition_Should_MoveRobotToEast() throws InvalidPositionException {
        CommandResult commandResult = moveCommand.execute();
        assertEquals("Successfully moved the Toy Robot to (1, 2) facing NORTH", commandResult.getMessage());
    }
}
