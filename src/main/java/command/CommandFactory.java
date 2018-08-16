package command;

import game.ToyRobotSimulator;
import exception.*;
import models.SimulationCommand;
import utils.CommandUtil;

public class CommandFactory {

    public static Command getCommandExecutor(SimulationCommand command, ToyRobotSimulator toyRobotSimulator) throws InvalidCommandException {
        switch (command) {
            case PLACE:
                return new PlaceCommand(toyRobotSimulator.getToyRobot(), toyRobotSimulator.getNewPosition());
            case MOVE:
                return new MoveCommand(toyRobotSimulator.getToyRobot(), toyRobotSimulator.getSquareTableTop());
            case LEFT:
                return new LeftCommand(toyRobotSimulator.getToyRobot());
            case RIGHT:
                return new RightCommand(toyRobotSimulator.getToyRobot());
            case REPORT:
                return new ReportCommand(toyRobotSimulator.getToyRobot());
            default:
                throw new InvalidCommandException(CommandUtil.GAME_COMMAND_HELPER);
        }
    }
}
