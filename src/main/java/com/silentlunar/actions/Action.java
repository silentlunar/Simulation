package src.main.java.com.silentlunar.actions;

import src.main.java.com.silentlunar.MapWorld;

abstract public class Action {
    MapWorld map;

    public Action(MapWorld map) {
        this.map = map;
    }
}
