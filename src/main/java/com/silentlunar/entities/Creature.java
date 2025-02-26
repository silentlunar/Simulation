package src.main.java.com.silentlunar.entities;

import src.main.java.com.silentlunar.Coordinates;
import src.main.java.com.silentlunar.MapWorld;

import java.util.List;
import java.util.Random;

abstract public class Creature extends Entity {
    private final int speed;
    private int healthPoints;

    Random random = new Random();

    public Creature() {
        this.speed = random.nextInt(1, 3);
        this.healthPoints = random.nextInt(6, 10);
    }

    abstract public void makeMove(MapWorld map, Coordinates coordinates);

    public void moveToObject(MapWorld map, List<Coordinates> path) {
        System.out.println(path);
        Entity entity = map.getEntity(path.getFirst());
        map.removeEntity(path.getFirst());
        map.addEntity(entity, path.get(1));
    }

    public void eatTarget(MapWorld map, List<Coordinates> path) {

        System.out.println(path.get(0) + " Eating " + path.get(1));
        map.removeEntity(path.get(1));
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
