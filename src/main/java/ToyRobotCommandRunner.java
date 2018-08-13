import Exception.GameException;
import Models.Board;
import Models.Robot;
import Models.SquareTableTop;

import java.util.Scanner;


public class ToyRobotCommandRunner {
    public static void main(String[] args) {
        // TODO replace all System.out.println with SLF4J logging.
        // Logger logger = LoggerFactory.getLogger(ToyRobotCommandRunner.class);
        Scanner standardInput = new Scanner(System.in);
        String command;
        //Init the game
        SquareTableTop squareBoard = new SquareTableTop(Board.BOARD_ROWS, Board.BOARD_COLUMNS);
        Robot toyRobot = new Robot();
        ToyRobotSimulator game = new ToyRobotSimulator(squareBoard, toyRobot);

        boolean running = true;
        while (running) {
            command = standardInput.nextLine();
            if ("EXIT".equalsIgnoreCase(command)) {
                running = false;
                System.exit(1);
            } else {
                try {
                    //TODO replace with logger.info(game.executeCommand(command));
                    System.out.println(game.executeCommand(command));
                } catch (GameException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
