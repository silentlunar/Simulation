package src.main.java.com.silentlunar;

public record Coordinates(int x, int y) {
    @Override
    public String toString() {
        return "[" + x +
                ", " + y +
                ']';
    }
}
