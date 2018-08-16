package command;

import models.Robot;
import utils.CommandUtil;

public class LeftCommand implements Command {
    private Robot toyRobot;

    public LeftCommand(Robot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public CommandResult execute() {
        toyRobot.rotateLeft();
        return CommandUtil.getCommandResult(toyRobot.getPosition());
    }
}
