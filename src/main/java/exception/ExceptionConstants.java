package exception;

import utils.CommandUtil;

public class ExceptionConstants {
    public static final String TOY_ROBOT_INVALID_POSITION = "Toy Robot is at an invalid position";
    public static final String INCOMPLETE_COMMAND_ARGUMENTS = "Command missing required arguments: Usage PLACE x,y,Direction";
    public static final String INVALID_DIRECTION_COMMAND = "Invalid Direction entered. Valid: North, South, East, West.";
    public static final String TOY_ROBOT_NOT_PLACED_ON_BOARD = "Toy Robot not placed on the board yet!!";
    public static final String TOY_ROBOT_PLACED_OUTSIDE = "Toy Robot Placed outside the board";
    public static final String INVALID_COMMAND_MESSAGE = "Invalid Command Provided: Command Usage\n"
            + CommandUtil.GAME_COMMAND_HELPER;
}
