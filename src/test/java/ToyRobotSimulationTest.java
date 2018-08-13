import Exception.GameException;
import Models.Board;
import Models.Robot;
import Models.SquareTableTop;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToyRobotSimulationTest {
    final int BOARD_ROWS = 5;
    final int BOARD_COLUMNS = 5;

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
    public void basicPlacingTest() throws GameException {
        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("MOVE");
        Assert.assertEquals("0,1,NORTH", game.executeCommand("REPORT"));
    }

    @Test
    public void testOutOfBoardPlacementIgnored() throws GameException {
        game.executeCommand("PLACE 10,0,NORTH");
        Assert.assertEquals("", game.executeCommand("REPORT"));
    }

    @Test
    public void testCommandsBeforePlaceAreIgnored() throws GameException {
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        game.executeCommand("RIGHT");
        Assert.assertEquals("", game.executeCommand("REPORT"));
    }

    @Test
    public void testAllCommands() throws GameException {
        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        game.executeCommand("MOVE");
        Assert.assertEquals("3,3,NORTH", game.executeCommand("REPORT"));
    }

    @Test(expected = GameException.class)
    public void testInvalidPlaceCommand() throws GameException {
        game.executeCommand("PLACE 1,EAST");
    }

    @Test
    public void testDuplicatePlaceCommands() throws GameException {
        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("MOVE");
        Assert.assertEquals("0,1,NORTH", game.executeCommand("REPORT"));

        game.executeCommand("PLACE 0,0,NORTH");
        game.executeCommand("LEFT");
        Assert.assertEquals("0,0,WEST", game.executeCommand("REPORT"));

        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        game.executeCommand("MOVE");
        Assert.assertEquals("3,3,NORTH", game.executeCommand("REPORT"));
    }

    @Test(expected = GameException.class)
    public void testInvalidMoveAndRightCommands() throws GameException {
        game.executeCommand("PLACE 1,2,EAST");
        game.executeCommand("movebla");
        game.executeCommand("leftbb");
        game.executeCommand("rightbb");
        Assert.assertEquals("1,2,EAST", game.executeCommand("REPORT"));
    }

    @Test
    public void testMoveCommand() throws GameException {
        game.executeCommand("PLACE 0,0,SOUTH");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("MOVE");
        game.executeCommand("LEFT");
        game.executeCommand("MOVE");
        Assert.assertEquals("1,0,EAST", game.executeCommand("REPORT"));
    }

}
