package src.main.java.com.silentlunar;

import src.main.java.com.silentlunar.actions.InitAction;
import src.main.java.com.silentlunar.actions.TurnAction;
import src.main.java.com.silentlunar.entities.Herbivore;
import src.main.java.com.silentlunar.entities.Predator;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Simulation {

    private final Renderer renderer = new Renderer();
    private final MapWorld map = new MapWorld(15, 15);
    private final InitAction initAction = new InitAction(map);
    private final TurnAction turnAction = new TurnAction(map);
    private boolean isGameOver = false;

    public void initMap(){
        initAction.initMap();
        renderer.render(map);
    }

    public void startSimulation() throws InterruptedException {
        while (!isGameOver) {
            TimeUnit.SECONDS.sleep(1);
            nextTurn();
        }
    }
    public void nextTurn() {
        turnAction.turnAction();
        renderer.render(map);
    }
    public void pauseSimulation(){
        isGameOver = true;
        System.out.println("~~~~~~~~~~~~~~~Game~over~~~~~~~~~~~~~~");
    }

}
