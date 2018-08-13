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
                commandOutput = report();
                break;
            case MOVE:
                MoveCommand moveCommand = new MoveCommand(toyRobot, squareTableTop);
                moveCommand.execute();
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
        }

        return commandOutput;
    }

    private void placeRobot(Position position) throws GameException {

        if (squareTableTop == null)
            throw new GameException("Board is not ready");

        if (position == null)
            throw new GameException("Invalid position for the robot");

        if (position.getDirection() == null)
            throw new GameException("Invalid direction provided");

        // validate the position
        if (!squareTableTop.isValidPosition(position))
            return;

        // if position is valid then assign the values
        toyRobot.setPosition(position);
    }

    private String validateInputCommands(String command, String[] arguments) throws GameException {
        String placeCommandArguments = "";
        try {
            SimulationCommand.valueOf(command);
        } catch (IllegalArgumentException exception) {
            throw new GameException("Invalid command");
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
            } catch (Exception e) {
                throw new GameException("Invalid command");
            }
        }
        return position;
    }

    private String report() {
        if (toyRobot.getPosition() == null)
            return null;

        return toyRobot.getPosition().getX() + "," + toyRobot.getPosition().getY() + ","
                + toyRobot.getPosition().getDirection().toString();
    }
}
