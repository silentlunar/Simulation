package src.main.java.com.silentlunar.entities;

import java.util.Random;

abstract public class Creature extends Entity {
    int speed;
    int healthPoints;

    Random random = new Random();

    public Creature() {
        this.speed = 1;
        this.healthPoints = random.nextInt(2, 10);
    }
    abstract public void makeMove();
}
