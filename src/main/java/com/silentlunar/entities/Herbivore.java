package src.main.java.com.silentlunar.entities;

import src.main.java.com.silentlunar.Coordinates;
import src.main.java.com.silentlunar.MapWorld;
import src.main.java.com.silentlunar.PathFinder;

import java.util.List;

public class Herbivore extends Creature {


    public Herbivore() {
    }

    @Override
    public String toString() {
        return "\uD83D\uDC20 ";
    }

    @Override
    public void makeMove(MapWorld map, Coordinates coordinates) {
        PathFinder pathFinder = new PathFinder(map);
        List<Coordinates> path = pathFinder.bfs(coordinates, new Herbivore());
        if (path.size() > 2) {
            moveToObject(map, path);
        } else if (path.size() == 2) {
            eatTarget(map, path);
        } else {
            System.out.println("Закончилась трава у травоядного - " + path.getFirst());
        }
    }
}
