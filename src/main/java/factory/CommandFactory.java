package factory;

import command.*;
import game.ToyRobotSimulator;
import models.SimulationCommand;

public class CommandFactory {
    private static Command commandExecutor;

    public static Command getCommandExecutor(SimulationCommand command, ToyRobotSimulator toyRobotSimulator) {
        switch (command) {
            case PLACE:
                commandExecutor = new PlaceCommand(toyRobotSimulator.getToyRobot(), toyRobotSimulator.getNewPosition());
                break;
            case MOVE:
                commandExecutor = new MoveCommand(toyRobotSimulator.getToyRobot(), toyRobotSimulator.getSquareTableTop());
                break;
            case LEFT:
                commandExecutor = new LeftCommand(toyRobotSimulator.getToyRobot());
                break;
            case RIGHT:
                commandExecutor = new RightCommand(toyRobotSimulator.getToyRobot());
                break;
            case REPORT:
                commandExecutor = new ReportCommand(toyRobotSimulator.getToyRobot());
                break;
        }
        return commandExecutor;
    }
}
