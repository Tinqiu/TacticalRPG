package pathing;

import java.util.*;

public class AStar {
    private final int width;
    private final int height;

    private final Map<Coordinates, Node> nodes;

    public AStar(Integer width, Integer height, List<Coordinates> wallPositions, Map<Coordinates, Node> nodes){
        this.width = width;
        this.height = height;
        this.nodes = nodes;

        for(Coordinates coord : wallPositions){
            Node node = nodes.get(coord);
            node.isBlocked = true;
        }
    }

    public List<Coordinates> calculateAStarPath(Coordinates start, Coordinates goal){
        Comparator<Node> fComparator = Comparator.comparing(Node::getFValue);
        PriorityQueue<Node> openList = new PriorityQueue<>(fComparator);
        Set<Node> closedList = new HashSet<>();

        Node destNode = nodes.get(goal);
        Node currentNode = nodes.get(start);

        currentNode.parent = null;
        currentNode.setGValue(0);
        openList.add(currentNode);

        while (!openList.isEmpty()){
            currentNode = openList.poll();

            if(currentNode.coord.equals(destNode.coord))
                return calculatePath(destNode);
            closedList.add(currentNode);

            for(Direction direction : Direction.values()){
                Coordinates adjacentCoords = direction.getCoordinatesForDirection(currentNode.coord);
                if(!this.isInsideBounds(adjacentCoords))
                    continue;

                Node adjacentNode = nodes.get(adjacentCoords);
                if(adjacentNode.isBlocked)
                    continue;

                if(!closedList.contains(adjacentNode)){
                    if(!openList.contains(adjacentNode)){
                        adjacentNode.parent = currentNode;
                        adjacentNode.calculateGValue(currentNode);
                        adjacentNode.calculateHValue(destNode);
                        openList.add(adjacentNode);
                    } else {
                        if(adjacentNode.gValue < currentNode.gValue){
                            adjacentNode.calculateGValue(currentNode);
                            currentNode = adjacentNode;
                        }
                    }
                }
            }
        }
        return Collections.emptyList();
    }

   private List<Coordinates> calculatePath(Node destNode){
        List<Coordinates> path = new ArrayList<>();
        Node node = destNode;
        while(node.parent != null){
            path.add(node.coord);
            node = node.parent;
        }
        return path;
   }

   private boolean isInsideBounds(Coordinates coordinates){
        return coordinates.x >= 0 &&
               coordinates.x < width &&
               coordinates.y >= 0 &&
               coordinates.y < height;
   }

   public Map<Coordinates, Node> getNodes(){
        return this.nodes;
   }

   public int getWidth(){
        return this.width;
   }

   public int getHeight(){
        return this.height;
   }
}






























