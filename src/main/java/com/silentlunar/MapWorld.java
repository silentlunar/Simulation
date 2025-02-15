package src.main.java.com.silentlunar;

import src.main.java.com.silentlunar.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class MapWorld {
    public final int height; // высота
    public final int width; // ширина


    private Map<Coordinates, Entity> map = new HashMap<>();

    public MapWorld(int height, int width) {
        this.height = height;
        this.width = width;
    }


    public void addEntity(Entity entity, Coordinates coordinates) {
        map.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates) {
        map.remove(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public Map<Coordinates, Entity> getMap() {
        return map;
    }

    public void setMap(HashMap<Coordinates, Entity> map) {
        this.map = map;
    }
}
