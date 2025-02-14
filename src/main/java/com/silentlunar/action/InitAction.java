package src.main.java.com.silentlunar.action;

import src.main.java.com.silentlunar.Coordinates;
import src.main.java.com.silentlunar.MapWorld;
import src.main.java.com.silentlunar.entity.*;

import java.util.Random;

public class InitAction extends Action {

    Random randomX = new Random(map.width); //x
    Random randomY = new Random(map.height); //y

    public InitAction(MapWorld map) {
        super(map);
    }


    public void initMap() {
        int size = map.height * map.width;
        int amountOfEntity = size / 3;
        int amountOfCreature = amountOfEntity / 4;
        int amountOfStaticObject = amountOfEntity - amountOfCreature;
        initStaticObject(amountOfStaticObject);
        initCreature(amountOfCreature);
    }

    public void initStaticObject(int amount) {
        int amountOfGrass = amount / 3;
        int amountOfBlock = amount - amountOfGrass;
        for (int i = 0; i < amountOfBlock; i++) {
            Coordinates coordinates = new Coordinates(randomY.nextInt(), randomX.nextInt());
            if (map.isCellEmpty(coordinates)) {
                if (coordinates.y() + coordinates.x() % 2 == 0) {
                    map.addEntity(new Shell(), coordinates);
                } else {
                    map.addEntity(new Rock(), coordinates);
                }
            } else {
                i--;
            }
        }
        for (int i = 0; i < amountOfGrass; i++) {
            Coordinates coordinates = new Coordinates(randomY.nextInt(), randomX.nextInt());
            if (map.isCellEmpty(coordinates)) {
                map.addEntity(new Grass(), coordinates);
            } else {
                i--;
            }
        }
    }

    public void initCreature(int amount) {
        int amountOfPredator = amount / 3;
        int amountOfHerbivore = amount - amountOfPredator;
        for (int i = 0; i < amountOfHerbivore; i++) {
            Coordinates coordinates = new Coordinates(randomY.nextInt(), randomX.nextInt());
            if (map.isCellEmpty(coordinates)) {
                map.addEntity(new Herbivore(1, 10), coordinates);
            } else {
                i--;
            }
        }
        for (int i = 0; i < amountOfPredator; i++) {
            Coordinates coordinates = new Coordinates(randomY.nextInt(), randomX.nextInt());
            if (map.isCellEmpty(coordinates)) {
                map.addEntity(new Predator(1, 10), coordinates);
            } else {
                i--;
            }
        }
    }
}

