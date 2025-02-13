package src.main.java.com.silentlunar;
import src.main.java.com.silentlunar.entity.Entity;

import java.util.HashMap;

public class MapWorld {
    public final int height; // высота
    public final int width; // ширина

    private HashMap<Coordinates, Entity> map = new HashMap<>();

    public MapWorld(int height, int width) {
        this.height = height;
        this.width = width;
    }
}
