package src.main.java.com.silentlunar;

import java.util.*;

import src.main.java.com.silentlunar.entities.*;

public class PathFinder {
    private final MapWorld map;
    private final boolean[][] visited;
    private final List<Coordinates> neighboursList;

    public PathFinder(MapWorld map) {
        this.map = map;
        visited = new boolean[map.height][map.width];
        neighboursList = new LinkedList<>();
    }

    public List<Coordinates> bfs(Coordinates start, Creature creature) {
        List<Coordinates> path = new ArrayList<>();
        visited[start.x()][start.y()] = true;
        findNeighbors(start);
        path.add(start);

        while (!neighboursList.isEmpty()) {
            Coordinates coordinates = neighboursList.getFirst();
            if (!map.isCellEmpty(coordinates)) {
                Entity entity = map.getEntity(coordinates);
                if (creature instanceof Predator) {
                    if (entity instanceof Herbivore) {
                        return findPathToObject(start, coordinates, path);
                    }
                }
                if (creature instanceof Herbivore) {
                    if (entity instanceof Grass) {
                        return findPathToObject(start, coordinates, path);

                    }
                }
            }
            findNeighbors(coordinates);
            neighboursList.removeFirst();

        }
        return path;
    }

    public void findNeighbors(Coordinates current) {
        int x = current.x();
        int y = current.y();
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (i >= 0 && j >= 0 && i < map.height && j < map.width) {
                    Coordinates neighbour = new Coordinates(i, j);
                    if (!visited[i][j]) {
                        neighboursList.add(neighbour);
                        visited[i][j] = true;
                    }
                }
            }
        }
    }

    public List<Coordinates> findPathToObject(Coordinates start, Coordinates target, List<Coordinates> path) {
        int x = start.x();
        int y = start.y();
        while (x != target.x() && y != target.y()) {
            if (x < target.x()) x++;
            if (x > target.x()) x--;
            if (y < target.y()) y++;
            if (y > target.y()) y--;

            path.add(new Coordinates(x, y));
        }

        while (x != target.x()) {
            if (x < target.x()) x++;
            else x--;
            path.add(new Coordinates(x, y));
        }

        while (y != target.y()) {
            if (y < target.y()) y++;
            else y--;
            path.add(new Coordinates(x, y));
        }
        return path;
    }
}

