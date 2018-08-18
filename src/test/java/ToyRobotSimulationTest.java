import exception.*;
import game.ToyRobotSimulator;
import models.Board;
import models.Robot;
import models.SquareTableTop;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToyRobotSimulationTest {
    static final int BOARD_ROWS = 4;
    static final int BOARD_COLUMNS = 4;

    private Board board;
    Robot toyRobot;
    ToyRobotSimulator game;

    @Before
    public void setUp() {
        board = new SquareTableTop(BOARD_COLUMNS, BOARD_ROWS);
        toyRobot = new Robot();
        game = new ToyRobotSimulator(board, toyRobot);
    }

    @Test
    public void executeCommandPlaceAndMove_AtNorth_Should_IncrementYAxisAndMoveToNorth() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("MOVE");
        assertEquals("Toy Robot position is: (0, 1) facing NORTH", game.executeCommand("REPORT"));
    }

    @Test(expected = InvalidPositionException.class)
    public void executeCommandPlace_OutOfBoard_ExceptionThrown() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 10,0,NORTH");
        game.executeCommand("REPORT");
    }

    @Test(expected = InvalidPositionException.class)
    public void executeCommand_WithOutPlace_ExceptionThrown() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        game.executeCommand("RIGHT");
        game.executeCommand("REPORT");
    }

    @Test
    public void executeCommands_PlacedAtEast_Should_ReportRobotFacingNorth() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        game.executeCommand("MOVE");
        assertEquals("Toy Robot position is: (3, 3) facing NORTH", game.executeCommand("REPORT"));
    }

    @Test(expected = InvalidCommandException.class)
    public void executeCommand_PlaceMissingArgs_ExceptionThrown() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 1,EAST");
    }

    @Test
    public void executeDuplicatePlace_Should_AllowFurtherCommands() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("MOVE");
        assertEquals("Toy Robot position is: (0, 1) facing NORTH", game.executeCommand("REPORT"));

        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("LEFT");
        assertEquals("Toy Robot position is: (0, 0) facing WEST", game.executeCommand("REPORT"));

        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        game.executeCommand("MOVE");
        assertEquals("Toy Robot position is: (3, 3) facing NORTH", game.executeCommand("REPORT"));
    }

    @Test(expected = InvalidCommandException.class)
    public void executeInvalidCommands_Should_ExceptionThrown() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("movebla");
        game.executeCommand("leftbb");
        game.executeCommand("rightbb");
        assertEquals("1,2,EAST", game.executeCommand("REPORT"));
    }

    @Test
    public void executeCommand_MoveFromNorth_Should_ReportRobotFacingWest() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        assertEquals("Toy Robot position is: (0, 3) facing WEST", game.executeCommand("REPORT"));
    }

    @Test
    public void executeCommandRight_PlacedAtEast_Should_ReportRobotFacingNorth() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 1,1,EAST");
        game.executeCommand("RIGHT");
        assertEquals("Toy Robot position is: (1, 1) facing SOUTH", game.executeCommand("REPORT"));
    }

    @Test(expected = InvalidCommandException.class)
    public void executeCommandPlace_WithoutArgs_ExceptionThrown() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE");
    }

    @Test(expected = InvalidPositionException.class)
    public void executeCommandPlace_WithInvalidDirection_ExceptionThrown() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 0,0,test");
    }
}
