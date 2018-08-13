import Models.Robot;

public class LeftCommand implements Command {
    private Robot toyRobot;

    public LeftCommand(Robot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public String execute() {
        toyRobot.rotateLeft();
        return "";
    }
}
