import command.CommandResult;
import exception.*;
import game.ToyRobotSimulator;
import models.Board;
import models.Robot;
import models.SquareTableTop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CommandUtil;

import java.util.Scanner;


public class ToyRobotCommandRunner {
    static Logger logger = LoggerFactory.getLogger(ToyRobotCommandRunner.class);
    static String commandResult;

    public static void main(String[] args) {
        //Init the game
        SquareTableTop squareBoard = new SquareTableTop(Board.BOARD_ROWS, Board.BOARD_COLUMNS);
        Robot toyRobot = new Robot();
        ToyRobotSimulator game = new ToyRobotSimulator(squareBoard, toyRobot);
        logger.info("Program Command Usage: \n" + CommandUtil.GAME_COMMAND_HELPER);

        startGameSimulation(game);
    }

    private static void startGameSimulation(ToyRobotSimulator game) {
        String command;
        Scanner standardInput = getStandardInput();
        boolean running = true;
        while (running) {
            command = getCommandFromStandardInput(standardInput);
            if ("EXIT".equalsIgnoreCase(command)) {
                System.exit(1);
            } else try {
                commandResult = game.executeCommand(command);
                logger.info(commandResult);
            } catch (InvalidCommandException | InvalidPositionException exception) {
                commandResult = exception.getMessage();
                logger.error("Exception: " + commandResult);
            }
        }
    }

    private static String getCommandFromStandardInput(Scanner standardInput) {
        return standardInput.hasNextLine() ? standardInput.nextLine() : "exit";
    }

    static Scanner getStandardInput() {
        return new Scanner(System.in);
    }
}
