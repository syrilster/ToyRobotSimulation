package Models;

import Exception.GameException;

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

    public Position getNextPosition() throws GameException {
        if (this.getDirection() == null)
            throw new GameException("Toy Robot is in a invalid position");

        // new position to be set as per the direction
        Position newPosition = null;
        switch (this.getDirection()) {
            case NORTH:
                newPosition = new Position(this.getX(), this.getY() + 1, this.getDirection());
                break;
            case SOUTH:
                newPosition = new Position(this.getX(), this.getY() - 1, this.getDirection());
                break;
            case EAST:
                newPosition = new Position(this.getX() + 1, this.getY(), this.getDirection());
                break;
            case WEST:
                newPosition = new Position(this.getX() - 1, this.getY(), this.getDirection());
                break;
        }
        return newPosition;
    }
}
