package mowitnow.domain;

public record Lawn(int width, int height) {
    public boolean isWithinBoundaries(Position position) {
        return position.x() >= 0 && position.x() <= width &&
               position.y() >= 0 && position.y() <= height;
    }
}
