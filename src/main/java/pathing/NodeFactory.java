package pathing;

import terrain.Terrain;
import terrain.TerrainFactory;
import terrain.TerrainType;

public final class NodeFactory {

    private NodeFactory(){}
    public static Node produce(int x, int y, TerrainType terrainType){
        Coordinates coordinates = new Coordinates(x,y);
        Terrain terrain = TerrainFactory.produce(terrainType);
        return new Node(coordinates, terrain);
    }
}
