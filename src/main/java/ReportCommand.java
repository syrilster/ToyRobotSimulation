import Models.Robot;

public class ReportCommand implements Command {
    private Robot toyRobot;

    public ReportCommand(Robot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public String execute() {
        return report();
    }

    private String report() {
        if (toyRobot.getPosition() == null)
            return null;

        return toyRobot.getPosition().getX() + "," + toyRobot.getPosition().getY() + ","
                + toyRobot.getPosition().getDirection().toString();
    }
}
