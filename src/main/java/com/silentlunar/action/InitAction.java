package src.main.java.com.silentlunar.action;

import src.main.java.com.silentlunar.Coordinates;
import src.main.java.com.silentlunar.MapWorld;
import src.main.java.com.silentlunar.entity.*;

import java.util.Random;

public class InitAction extends Action {

    private final static int STATIC_OBJECT_RATIO = 3;
    private final static int CREATURE_RATIO = 4;

    Random random = new Random();

    public InitAction(MapWorld map) {
        super(map);
    }


    public void initMap() {
        int size = map.height * map.width;
        int totalEntity = size / STATIC_OBJECT_RATIO;
        int totalCreature = totalEntity / CREATURE_RATIO;
        int totalStaticObjects = totalEntity - totalCreature;
        initStaticObjects(totalStaticObjects);
        initCreatures(totalCreature);
    }

    public void initStaticObjects(int amount) {
        int totalGrass = amount / STATIC_OBJECT_RATIO;
        int totalBlock = amount - totalGrass;
        addEntityToMap(new Grass(), totalGrass);
        addEntityToMap(new Shell(), totalBlock / 2);
        addEntityToMap(new Rock(), totalBlock / 2);
    }

    public void initCreatures(int amount) {
        int totalPredator = amount / 3;
        int totalHerbivore = amount - totalPredator;
        addEntityToMap(new Herbivore(), totalHerbivore);
        addEntityToMap(new Predator(), totalPredator);
    }

    public void addEntityToMap(Entity entity, int amount) {
        while (amount > 0) {
            Coordinates coordinates = new Coordinates(random.nextInt(map.width), random.nextInt(map.height));
            if (map.isCellEmpty(coordinates)) {
                map.addEntity(entity, coordinates);
                amount--;
            }
        }
    }
}


