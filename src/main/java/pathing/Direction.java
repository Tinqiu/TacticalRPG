package pathing;

public enum Direction {
    UP(0,1),
    DOWN(0,-1),
    LEFT(-1,0),
    RIGHT(1,0);

    private final int x;
    private final int y;

    Direction(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Coordinates getCoordinatesForDirection(Coordinates coord){
        return new Coordinates(coord.x + this.x, coord.y + this.y);
    }
}
