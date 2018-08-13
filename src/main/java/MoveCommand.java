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
            newPosition = toyRobot.getPosition().getNextPosition();
            toyRobot.setPosition(newPosition);
        } catch (GameException e) {
            e.printStackTrace();
        }
        return "";
    }
}
