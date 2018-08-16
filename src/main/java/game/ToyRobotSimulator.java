package game;

import command.CommandFactory;
import command.CommandResult;
import exception.InvalidCommandException;
import exception.InvalidPositionException;
import models.Board;
import models.Position;
import models.Robot;
import models.SimulationCommand;
import utils.PositionUtil;
import validator.CommandValidator;

public class ToyRobotSimulator {
    private Board squareTableTop;
    private Robot toyRobot;
    private Position newPosition;

    public ToyRobotSimulator(Board squareTableTop, Robot toyRobot) {
        this.squareTableTop = squareTableTop;
        this.toyRobot = toyRobot;
    }

    public String executeCommand(String inputCommand) throws InvalidCommandException, InvalidPositionException {
        Position position;
        SimulationCommand command;
        CommandResult commandResult = null;
        String[] arguments = inputCommand.split(" ");
        String argumentOne = arguments[0];

        command = validateAndGetInputCommand(argumentOne);
        if (isInputCommandPlace(command) && isValidPlaceCommand(arguments))
            newPosition = PositionUtil.populateInitialPosition(arguments[1]);
        position = newPosition != null ? newPosition : toyRobot.getPosition();
        if (squareTableTop.isValidPosition(position)) {
            commandResult = CommandFactory
                    .getCommandExecutor(command, this)
                    .execute();
        }
        return commandResult != null ? commandResult.getMessage() : "";
    }

    private SimulationCommand validateAndGetInputCommand(String command) throws InvalidCommandException {
        return CommandValidator.validateAndGetInputCommand(command);
    }

    private boolean isInputCommandPlace(SimulationCommand command) throws InvalidCommandException {
        return CommandValidator.isInputCommandPlace(command);
    }

    private boolean isValidPlaceCommand(String[] arguments) throws InvalidCommandException {
        return CommandValidator.validatePlaceCommand(arguments);
    }

    public Board getSquareTableTop() {
        return squareTableTop;
    }

    public void setSquareTableTop(Board squareTableTop) {
        this.squareTableTop = squareTableTop;
    }

    public Robot getToyRobot() {
        return toyRobot;
    }

    public void setToyRobot(Robot toyRobot) {
        this.toyRobot = toyRobot;
    }

    public Position getNewPosition() {
        return newPosition;
    }
}
