import Models.Board;
import Models.Robot;

public class LeftCommand implements Command {
    private Robot toyRobot;
    private Board squareTableTop;

    public LeftCommand(Robot toyRobot, Board squareTableTop) {
        this.toyRobot = toyRobot;
        this.squareTableTop = squareTableTop;
    }

    @Override
    public String execute() {
        if (squareTableTop.isValidPosition(toyRobot.getPosition())) {
            toyRobot.rotateLeft();
        }
        return "";
    }
}
