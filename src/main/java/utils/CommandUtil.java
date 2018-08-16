package utils;

import models.Position;
import command.CommandResult;

public class CommandUtil {
    public static final String GAME_COMMAND_HELPER = "Place:  Places the robot on the table at an x,y coordinate facing a direction of NORTH, SOUTH, EAST or WEST \"Ex: place x y facing\"\n" +
            "Move:   Moves the robot 1 unit in the direction it's facing.\n" +
            "Left:   Rotates the robot left to a new facing.\n" +
            "Right:  Rotates the robot right to a new facing.\n" +
            "Report: Report on the robot's current position and facing.\n" +
            "Exit:   Quits the simulator";

    public static CommandResult getCommandResult(Position position) {
        return new CommandResult(
                "Successfully moved the Toy Robot to (%s, %s) facing %s",
                position.getX(),
                position.getY(),
                position.getDirection()
        );
    }

    public static CommandResult getPlaceCommandResult(Position position) {
        return new CommandResult(
                "Successfully placed the Toy Robot to (%s, %s) facing %s",
                position.getX(),
                position.getY(),
                position.getDirection()
        );
    }

    public static CommandResult getReportCommandResult(Position position) {
        return new CommandResult(
                "Toy Robot position is: (%s, %s) facing %s",
                position.getX(),
                position.getY(),
                position.getDirection()
        );
    }
}
