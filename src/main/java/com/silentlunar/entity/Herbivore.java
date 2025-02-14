package src.main.java.com.silentlunar.entity;

import java.util.Random;

public class Herbivore extends Creature {
    public Herbivore() {
        super(1, 10);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC20 ";
    }

    @Override
    public void makeMove() {

    }
}
