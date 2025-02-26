package src.main.java.com.silentlunar.entities;

import src.main.java.com.silentlunar.Coordinates;
import src.main.java.com.silentlunar.MapWorld;
import src.main.java.com.silentlunar.PathFinder;

import java.util.List;

public class Predator extends Creature {
    final int attackPoint;

    public Predator() {
        this.attackPoint = random.nextInt(4, 8);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD91 ";
    }

    @Override
    public void makeMove(MapWorld map, Coordinates coordinates) {
        PathFinder pathFinder = new PathFinder(map);
        List<Coordinates> path = pathFinder.bfs(coordinates, new Predator());
        if (path.size() > 1) {
            moveToObject(map, path);
        } else {
            eatTarget(map, path);
        }
    }
}
