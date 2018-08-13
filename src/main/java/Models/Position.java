package Models;

public class Position {
    private int x;
    private int y;
    Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    Position getNextPosition() throws GameException {
        if (this.getDirection() == null)
            throw new GameException("Toy Robot is in a invalid position");

        // new position to be set as per the direction
        Position newPosition = null;
        switch (this.getDirection()) {
            case Direction.NORTH:
                newPosition = new Position(this.getX(), this.getY() + 1, this.getDirection());
                break;
            case Direction.SOUTH:
                newPosition = new Position(this.getX(), this.getY() - 1, this.getDirection());
                break;
            case Direction.EAST:
                newPosition = new Position(this.getX() + 1, this.getY(), this.getDirection());
                break;
            case Direction.WEST:
                newPosition = new Position(this.getX() - 1, this.getY(), this.getDirection());
                break;
        }
        return newPosition;
    }
}
