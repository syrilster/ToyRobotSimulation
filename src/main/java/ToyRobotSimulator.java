import Models.*;
import Exception.GameException;

public class ToyRobotSimulator {
    private Board squareTableTop;
    private Robot toyRobot;

    public ToyRobotSimulator(Board squareTableTop, Robot toyRobot) {
        this.squareTableTop = squareTableTop;
        this.toyRobot = toyRobot;
    }

    String executeCommand(String inputCommand) throws GameException {
        String commandOutput = "";
        Position position;
        String[] arguments = inputCommand.split(" ");
        String command = arguments[0];
        String placeCommandArgs;

        placeCommandArgs = validateInputCommands(command, arguments);

        switch (SimulationCommand.valueOf(command)) {
            case PLACE:
                position = populateInitialPosition(command, placeCommandArgs);
                PlaceCommand placeCommand = new PlaceCommand(toyRobot, squareTableTop, position);
                placeCommand.execute();
                break;
            case REPORT:
                ReportCommand reportCommand = new ReportCommand(toyRobot, squareTableTop);
                commandOutput = reportCommand.execute();
                break;
            case MOVE:
                MoveCommand moveCommand = new MoveCommand(toyRobot, squareTableTop);
                moveCommand.execute();
                break;
            case LEFT:
                LeftCommand leftCommand = new LeftCommand(toyRobot, squareTableTop);
                leftCommand.execute();
                break;
            case RIGHT:
                RightCommand rightCommand = new RightCommand(toyRobot, squareTableTop);
                rightCommand.execute();
                break;
        }

        return commandOutput;
    }

    private String validateInputCommands(String command, String[] arguments) throws GameException {
        String placeCommandArguments = "";
        try {
            SimulationCommand.valueOf(command);
        } catch (IllegalArgumentException exception) {
            throw new GameException("Invalid command" + " " + exception.getMessage());
        }

        if (SimulationCommand.valueOf(command) == SimulationCommand.PLACE) {
            if (arguments.length < 2) {
                throw new GameException("Command missing required arguments: Usage PLACE x,y,Direction");
            } else {
                placeCommandArguments = arguments[1];
            }
        }

        return placeCommandArguments;
    }

    private Position populateInitialPosition(String command, String placeCommandArgs) throws GameException {
        Position position = null;
        // validate PLACE command params
        String[] placeCommandParams;
        int x;
        int y;
        Direction direction;
        if (SimulationCommand.valueOf(command) == SimulationCommand.PLACE) {
            placeCommandParams = placeCommandArgs.split(",");
            try {
                x = Integer.parseInt(placeCommandParams[0]);
                y = Integer.parseInt(placeCommandParams[1]);
                direction = Direction.valueOf(placeCommandParams[2]);
                position = new Position(x, y, direction);
                if (!this.squareTableTop.isValidPosition(position)) {
                    throw new GameException("PLACED outside the board");
                }
            } catch (Exception e) {
                throw new GameException("Invalid command" + " " + e.getMessage());
            }
        }
        return position;
    }
}
