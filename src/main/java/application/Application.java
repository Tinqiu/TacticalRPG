package application;

import pathing.AStar;
import pathing.Coordinates;
import pathing.Node;
import pathing.NodeFactory;
import terrain.TerrainType;

import java.security.InvalidParameterException;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        int width = 7;
        int height = 7;
        Coordinates start = new Coordinates(0, 0);
        Coordinates dest = new Coordinates(5, 4);
        Map<Coordinates, Node> nodes = generateMap(width, height);
        List<Coordinates> wallList = new ArrayList<>();
        //wallList.add(new Coordinates(0, 1));
        wallList.add(new Coordinates(1,1));
        wallList.add(new Coordinates(1, 0));

        AStar path = new AStar(width, height, wallList, nodes);
        drawTerrainMap(path);
        List<Coordinates> result = path.calculateAStarPath(start, dest);
        drawMapWithFValues(start, dest, path);
        for (Coordinates coord : result) {
            System.out.print(String.format("[%d,%d],", coord.x, coord.y));
        }
    }

    private static void drawTerrainMap(AStar aStar) {
        String[][] map = new String[aStar.getWidth()][aStar.getHeight()];
        Map<Coordinates, Node> nodes = aStar.getNodes();


        for (Coordinates coords : nodes.keySet()) {

            switch (nodes.get(coords).getTerrain().getTerrainType()) {
                case GRASSLAND:
                    map[coords.x][coords.y] = "G\t";
                    break;
                case SWAMP:
                    map[coords.x][coords.y] = "S\t";
                    break;
                case COBBLESTONE:
                    map[coords.x][coords.y] = "C\t";
                    break;
                default:
                    throw new InvalidParameterException();
            }
        }

        printMap(map, aStar.getWidth(), aStar.getHeight());

    }

    private static void drawMapWithFValues(Coordinates start, Coordinates dest, AStar aStar) {
        String[][] map = new String[aStar.getWidth()][aStar.getHeight()];
        Map<Coordinates, Node> nodes = aStar.getNodes();


        for (Coordinates coords : nodes.keySet()) {
            if (nodes.get(coords).isBlocked)
                map[coords.x][coords.y] = "X\t";
            else
                map[coords.x][coords.y] = nodes.get(coords).getFValue().toString() + "\t";
        }
        map[start.x][start.y] = "*\t";
        map[dest.x][dest.y] = "D\t";

        printMap(map, aStar.getWidth(), aStar.getHeight());
    }

    private static Map<Coordinates, Node> generateMap(int width, int height) {
        Map<Coordinates, Node> map = new HashMap<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Random random = new Random();
                int terrainSwitcher = (x * y + random.nextInt() + 1) % 3;
                TerrainType terrainType;
                switch (terrainSwitcher) {
                    case 1:
                        terrainType = TerrainType.SWAMP;
                        break;
                    case 2:
                        terrainType = TerrainType.COBBLESTONE;
                        break;
                    default:
                        terrainType = TerrainType.GRASSLAND;

                }
                Node node = NodeFactory.produce(x, y, terrainType);
                map.put(node.getCoordinates(), node);
            }
        }
        return map;
    }

    private static void printMap(String[][] map, int width, int height){
        System.out.println();
        for (int y = height - 1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                System.out.print(map[x][y]);
            }
            System.out.println();
        }
    }
}
