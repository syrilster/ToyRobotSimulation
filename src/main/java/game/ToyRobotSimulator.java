package game;

import factory.CommandFactory;
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
        String[] arguments = inputCommand.split(" ");
        String argumentOne = arguments[0];

        command = validateAndGetInputCommand(argumentOne);
        position = getPosition(command, arguments);
        return executeInputCommandAndGetOutput(position, command);
    }

    private String executeInputCommandAndGetOutput(Position position, SimulationCommand command) throws InvalidPositionException {
        CommandResult commandResult = null;
        if (squareTableTop.isValidPosition(position)) {
            commandResult = CommandFactory.getCommandExecutor(command, this)
                    .execute();
        }
        return commandResult != null ? commandResult.getMessage() : "";
    }

    private Position getPosition(SimulationCommand command, String[] arguments) throws InvalidCommandException, InvalidPositionException {
        if (isInputCommandPlace(command) && isValidPlaceCommand(arguments))
            newPosition = PositionUtil.populateInitialPosition(arguments[1]);
        return newPosition != null ? newPosition : toyRobot.getPosition();
    }

    private SimulationCommand validateAndGetInputCommand(String command) throws InvalidCommandException {
        return CommandValidator.validateAndGetInputCommand(command);
    }

    private boolean isInputCommandPlace(SimulationCommand command) {
        return CommandValidator.isInputCommandPlace(command);
    }

    private boolean isValidPlaceCommand(String[] arguments) throws InvalidCommandException {
        return CommandValidator.validatePlaceCommand(arguments);
    }

    public Board getSquareTableTop() {
        return squareTableTop;
    }

    public Robot getToyRobot() {
        return toyRobot;
    }

    public Position getNewPosition() {
        return newPosition;
    }
}
