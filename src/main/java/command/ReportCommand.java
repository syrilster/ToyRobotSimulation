package command;

import models.Robot;
import utils.CommandUtil;

public class ReportCommand implements Command {
    private Robot toyRobot;

    public ReportCommand(Robot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public CommandResult execute() {
        return CommandUtil.getReportCommandResult(toyRobot.getPosition());
    }
}
