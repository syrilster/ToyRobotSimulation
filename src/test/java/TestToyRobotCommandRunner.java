import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TestToyRobotCommandRunner {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void executeCommandPlace_WithValidArgs_RobotPlacedSuccessfully() {
        String data = "PLACE 0,0,north";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> assertEquals("Successfully placed the Toy Robot to (0, 0) facing NORTH",
                ToyRobotCommandRunner.commandResult));
        ToyRobotCommandRunner.main(new String[]{});
        when(ToyRobotCommandRunner.getStandardInput()).thenReturn(scanner);
    }

    @Test
    public void executeCommandPlace_WithInvalidCoordinates_ExceptionMessage() {
        String data = "PLACE 10,10,north";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> assertEquals("Toy Robot Placed outside the board",
                ToyRobotCommandRunner.commandResult));
        ToyRobotCommandRunner.main(new String[]{});
        when(ToyRobotCommandRunner.getStandardInput()).thenReturn(scanner);
    }

    @Test
    public void executeCommandPlace_WithInvalidArgs_ExceptionMessage() {
        String command = "PLACE";
        System.setIn(new ByteArrayInputStream(command.getBytes()));
        Scanner scanner = new Scanner(System.in);

        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> assertEquals("Command missing required arguments: Usage PLACE x,y,Direction",
                ToyRobotCommandRunner.commandResult));
        ToyRobotCommandRunner.main(new String[]{});
        when(ToyRobotCommandRunner.getStandardInput()).thenReturn(scanner);
    }
}
