import javafx.geometry.Pos;

public class PlaceCommand implements Command {
    private Robot toyRobot;
    private Board squareTableTop;
    private Position position;

    public PlaceCommand(Robot toyRobot, Board squareTableTop, Position position) {
        this.toyRobot = toyRobot;
        this.squareTableTop = squareTableTop;
        this.position = position;
    }

    @Override
    public void execute() {
        try {
            placeRobot(position);
        } catch (GameException e) {
            e.printStackTrace();
        }
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
}
