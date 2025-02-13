package src.main.java.com.silentlunar.entity;

public class Predator extends Creature {
    public Predator(int speed, int healthPoints) {
        super(speed, healthPoints);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD88 ";
    }

    @Override
    public void makeMove() {

    }
}
