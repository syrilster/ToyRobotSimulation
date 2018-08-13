public class RightCommand implements Command {
    private Robot toyRobot;

    public RightCommand(Robot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public String execute() {
        toyRobot.rotateRight();
        return "";
    }
}
