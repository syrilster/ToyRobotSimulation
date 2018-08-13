import Models.Board;
import Models.Robot;

public class ReportCommand implements OutPutCommand {
    private Robot toyRobot;
    private Board squareTableTop;

    public ReportCommand(Robot toyRobot, Board squareTableTop) {
        this.toyRobot = toyRobot;
        this.squareTableTop = squareTableTop;
    }

    @Override
    public String execute() {
        return report();
    }

    private String report() {
        if (squareTableTop.isValidPosition(toyRobot.getPosition())) {
            return toyRobot.getPosition().getX() + "," + toyRobot.getPosition().getY() + ","
                    + toyRobot.getPosition().getDirection().toString();
        }
        return "";
    }
}
