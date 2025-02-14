package src.main.java.com.silentlunar.entity;

import java.util.Random;

public class Predator extends Creature {
    public Predator() {
        super(1, 10);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD91 ";
    }

    @Override
    public void makeMove() {

    }
}
