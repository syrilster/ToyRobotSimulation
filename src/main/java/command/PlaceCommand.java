package command;


import models.Position;
import models.Robot;
import utils.CommandUtil;

import java.util.Objects;

public class PlaceCommand implements Command {
    private Robot toyRobot;
    private Position position;

    public PlaceCommand(Robot toyRobot, Position position) {
        this.toyRobot = toyRobot;
        this.position = position;
    }

    @Override
    public CommandResult execute() {
        toyRobot.setPosition(position);
        return CommandUtil.getPlaceCommandResult(position);
    }
}
