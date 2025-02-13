package src.main.java.com.silentlunar;
import src.main.java.com.silentlunar.action.InitAction;
import src.main.java.com.silentlunar.action.TurnAction;

public class Simulation {
    private final InitAction initAction = new InitAction();
    private final TurnAction turnAction = new TurnAction();
    private final Renderer renderer = new Renderer();
    private MapWorld map;
}
