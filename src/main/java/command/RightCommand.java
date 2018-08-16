package command;

import models.Robot;
import utils.CommandUtil;

public class RightCommand implements Command {
    private Robot toyRobot;

    public RightCommand(Robot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public CommandResult execute() {
        toyRobot.rotateRight();
        return CommandUtil.getCommandResult(toyRobot.getPosition());
    }
}
