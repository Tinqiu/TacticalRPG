package terrain;

import java.security.InvalidParameterException;

public final class TerrainFactory {

    private TerrainFactory(){}
    public static Terrain produce(TerrainType terrainType){
        switch (terrainType){
            case GRASSLAND:
                return new Grassland();
            case SWAMP:
                return new Swamp();
            case COBBLESTONE:
                return new Cobblestone();
            default: throw new InvalidParameterException();
        }
    }
}
