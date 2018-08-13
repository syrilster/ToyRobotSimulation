import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class MainParser {
    public static void main(String[] args) {
        Scanner standardInput = new Scanner(System.in);
        String command;

        boolean running = true;
        while (running) {
            command = standardInput.nextLine();
            if ("EXIT".equalsIgnoreCase(command)) {
                running = false;
                System.exit(1);
            } else {
                //Init the game
                SquareTableTop squareBoard = new SquareTableTop(5, 5);
                Robot toyRobot = new Robot();
                ToyRobotSimulator game = new ToyRobotSimulator(squareBoard, toyRobot);

                try {
                    game.executeCommand(command);
                } catch (GameException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
