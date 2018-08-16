package command;

import exception.InvalidPositionException;
import models.Board;
import models.Position;
import models.Robot;
import utils.CommandUtil;

public class MoveCommand implements Command {
    private Robot toyRobot;
    private Board squareTableTop;

    public MoveCommand(Robot toyRobot, Board squareTableTop) {
        this.toyRobot = toyRobot;
        this.squareTableTop = squareTableTop;
    }

    @Override
    public CommandResult execute() throws InvalidPositionException {
        Position newPosition;
        newPosition = toyRobot.getPosition().getNextPosition();
        if (squareTableTop.isValidPosition(newPosition))
            toyRobot.move(newPosition);
        return CommandUtil.getCommandResult(newPosition);
    }
}
