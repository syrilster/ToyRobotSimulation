public class ToyRobotSimulator {
    Board squareTableTop;
    Robot toyRobot;

    public ToyRobotSimulator(Board squareTableTop, Robot toyRobot) {
        this.squareTableTop = squareTableTop;
        this.toyRobot = toyRobot;
    }

    public String executeCommand(String inputCommand) throws GameException {
        String[] arguments = inputCommand.split(" ");
        String command = arguments[0];
        String placeCommandArgs;
        try {
            SimulationCommand.valueOf(command);
        } catch (IllegalArgumentException exception) {
            throw new GameException("Invalid command");
        }

        if (SimulationCommand.valueOf(command) == SimulationCommand.PLACE && arguments.length < 2) {
            throw new GameException("Command missing required arguments: Usage PLACE x,y,Direction");
        }

        placeCommandArgs = arguments[1];
        Position position = populateInitialPosition(command, placeCommandArgs);
        System.out.println(position.getX());
        System.out.println(position.getY());
        System.out.println(position.getDirection());

        return command;
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
}
