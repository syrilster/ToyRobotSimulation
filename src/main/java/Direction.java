public enum Direction {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private int direction;

    Direction(int direction){
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
