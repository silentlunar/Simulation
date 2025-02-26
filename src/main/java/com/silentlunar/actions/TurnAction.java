package src.main.java.com.silentlunar.actions;

import src.main.java.com.silentlunar.Coordinates;
import src.main.java.com.silentlunar.MapWorld;
import src.main.java.com.silentlunar.entities.Creature;

import java.util.ArrayList;
import java.util.List;

public class TurnAction extends Action {
    public TurnAction(MapWorld map) {
        super(map);
    }

    public void turnAction() {
        List<Creature> creatures = new ArrayList<>();
        List<Coordinates> coorList = new ArrayList<>();
        for (Coordinates coordinates : map.getMap().keySet()) {

            if (map.getEntity(coordinates) instanceof Creature) {
                creatures.add((Creature) map.getEntity(coordinates));
                coorList.add(coordinates);
            }
        }
        for (int i = 0; i < creatures.size(); i++) {
            if (!map.isCellEmpty(coorList.get(i)))
                creatures.get(i).makeMove(map, coorList.get(i));
        }

    }
}

