public class Robot {
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Rotates the robot 90 degree LEFT
     */
    public void rotateLeft() {
        this.position.setDirection(this.position.getDirection().leftDirection());
    }

    /**
     * Rotates the robot 90 degree RIGHT
     */
    public void rotateRight() {
        this.position.setDirection(this.position.getDirection().rightDirection());
    }
}
