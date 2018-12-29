package pathing;

import terrain.Terrain;

public class Node {
    public Node parent;
    public Coordinates coord;

    //g represents the movement cost to move from the starting point to a given square on the grid
    public int gValue;
    //h represents the estimated movement cost to move from that given square on the grid to the final destination
    public int hValue;

    public boolean isBlocked = false;
    private Terrain terrain;

    Node(Coordinates coordinates, Terrain terrain) {
        this.coord = coordinates;
        this.terrain = terrain;
    }

    /**
     * Used for setting the starting node value to 0
     */
    public void setGValue(Integer gValue) {
        this.gValue = gValue;
    }

    public void calculateHValue(Node destPoint) {
        this.hValue = (int) Math.ceil((Math.abs(coord.x - destPoint.coord.x) + Math.abs(coord.y - destPoint.coord.y)) * this.terrain.getMOVEMENT_COST());
    }

    public void calculateGValue(Node node) {
        this.gValue = (int) Math.ceil(node.gValue + this.terrain.getMOVEMENT_COST());
    }

    public Integer getFValue() {
        return this.gValue + this.hValue;
    }

    public Coordinates getCoordinates() {
        return coord;
    }

    public Terrain getTerrain() {
        return this.terrain;
    }
}
