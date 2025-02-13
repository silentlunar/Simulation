package src.main.java.com.silentlunar.entity;

abstract public class Creature extends Entity {
    int speed;
    int healthPoints;

    public Creature(int speed, int healthPoints) {
        this.speed = speed;
        this.healthPoints = healthPoints;
    }
    abstract public void makeMove();
}
