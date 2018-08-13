import Models.Board;
import Models.Position;
import Models.Robot;
import Exception.GameException;

public class MoveCommand implements Command {
    private Robot toyRobot;
    private Board squareTableTop;
    private Position position;

    public MoveCommand(Robot toyRobot, Board squareTableTop) {
        this.toyRobot = toyRobot;
        this.squareTableTop = squareTableTop;
    }

    @Override
    public String execute() {
        Position newPosition;
        try {
            if (squareTableTop.isValidPosition(toyRobot.getPosition())) {
                newPosition = toyRobot.getPosition().getNextPosition();
                if (squareTableTop.isValidPosition(newPosition))
                    toyRobot.setPosition(newPosition);
            }
        } catch (GameException e) {
            e.printStackTrace();
        }
        return "";
    }
}
