import exception.*;
import game.ToyRobotSimulator;
import models.Board;
import models.Robot;
import models.SquareTableTop;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToyRobotSimulationTest {
    static final int BOARD_ROWS = 5;
    static final int BOARD_COLUMNS = 5;

    private Board board;
    Robot toyRobot;
    ToyRobotSimulator game;

    @Before
    public void setUp() {
        board = new SquareTableTop(BOARD_COLUMNS, BOARD_ROWS);
        toyRobot = new Robot();
        game = new ToyRobotSimulator(board, toyRobot);
    }

    @After
    public void tearDown() {
        //Clean up here
        board = null;
        toyRobot = null;
        game = null;
    }

    @Test
    public void basicPlacingTest() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("MOVE");
        Assert.assertEquals("Toy Robot position is: (0, 1) facing NORTH", game.executeCommand("REPORT"));
    }

    @Test(expected = InvalidPositionException.class)
    public void testOutOfBoardPlacementIgnored() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 10,0,NORTH");
        game.executeCommand("REPORT");
    }

    @Test(expected = InvalidPositionException.class)
    public void testCommandsBeforePlaceAreIgnored() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        game.executeCommand("RIGHT");
        game.executeCommand("REPORT");
    }

    @Test
    public void testAllCommands() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        game.executeCommand("MOVE");
        Assert.assertEquals("Toy Robot position is: (3, 3) facing NORTH", game.executeCommand("REPORT"));
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidPlaceCommand() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 1,EAST");
    }

    @Test
    public void testDuplicatePlaceCommands() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("MOVE");
        Assert.assertEquals("Toy Robot position is: (0, 1) facing NORTH", game.executeCommand("REPORT"));

        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("LEFT");
        Assert.assertEquals("Toy Robot position is: (0, 0) facing WEST", game.executeCommand("REPORT"));

        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        game.executeCommand("MOVE");
        Assert.assertEquals("Toy Robot position is: (3, 3) facing NORTH", game.executeCommand("REPORT"));
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidMoveAndRightCommands() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("movebla");
        game.executeCommand("leftbb");
        game.executeCommand("rightbb");
        Assert.assertEquals("1,2,EAST", game.executeCommand("REPORT"));
    }

    @Test
    public void testMoveCommand() throws InvalidCommandException, InvalidPositionException {
        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        Assert.assertEquals("Toy Robot position is: (0, 3) facing WEST", game.executeCommand("REPORT"));
    }
}
