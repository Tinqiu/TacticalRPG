package terrain;

public class Terrain {
    private final double MOVEMENT_COST;
    private final TerrainType terrainType;

    Terrain(double movementCost, TerrainType terrainType){
        this.MOVEMENT_COST = movementCost;
        this.terrainType = terrainType;
    }

    public double getMOVEMENT_COST(){
        return MOVEMENT_COST;
    }

    public TerrainType getTerrainType(){
        return this.terrainType;
    }


}
