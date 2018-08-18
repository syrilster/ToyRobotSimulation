package command;

import exception.InvalidPositionException;
import models.Direction;
import models.Position;
import models.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestReportCommand {
    private Command reportCommand;

    @Before
    public void setUp() {
        Robot toyRobot = new Robot();
        Position position = new Position(1, 0, Direction.NORTH);
        toyRobot.setPosition(position);
        reportCommand = new ReportCommand(toyRobot);
    }

    @Test
    public void executeReport_AtInitialPosition_Should_OutputCorrectPosition() throws InvalidPositionException {
        CommandResult commandResult = reportCommand.execute();
        assertEquals("Toy Robot position is: (1, 0) facing NORTH", commandResult.getMessage());
    }
}
