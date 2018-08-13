import Models.Board;
import Models.Robot;

public class RightCommand implements Command {
    private Robot toyRobot;
    private Board squareTableTop;

    public RightCommand(Robot toyRobot, Board squareTableTop) {
        this.toyRobot = toyRobot;
        this.squareTableTop = squareTableTop;
    }

    @Override
    public String execute() {
        if (squareTableTop.isValidPosition(toyRobot.getPosition())) {
            toyRobot.rotateRight();
        }
        return "";
    }
}
