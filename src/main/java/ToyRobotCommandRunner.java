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
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ToyRobotCommandRunner.class);
        Scanner standardInput = new Scanner(System.in);
        String command;
        //Init the game
        SquareTableTop squareBoard = new SquareTableTop(Board.BOARD_ROWS, Board.BOARD_COLUMNS);
        Robot toyRobot = new Robot();
        ToyRobotSimulator game = new ToyRobotSimulator(squareBoard, toyRobot);
        logger.info("Program Command Usage: \n" + CommandUtil.GAME_COMMAND_HELPER);

        boolean running = true;
        while (running) {
            command = standardInput.nextLine();
            if ("EXIT".equalsIgnoreCase(command)) {
                running = false;
                System.exit(1);
            } else try {
                logger.info(game.executeCommand(command));
            } catch (InvalidCommandException | InvalidPositionException exception) {
                logger.error("Exception: " + exception.getMessage());
            }
        }
    }
}
