import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class MainParser {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(MainParser.class);
        Scanner standardInput = new Scanner(System.in);
        String command;
        //Init the game
        SquareTableTop squareBoard = new SquareTableTop(5, 5);
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
                    //Will replace with logger.info(game.executeCommand(command));
                    System.out.println(game.executeCommand(command));
                } catch (GameException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
