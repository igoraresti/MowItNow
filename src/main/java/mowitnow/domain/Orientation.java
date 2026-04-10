package mowitnow.domain;

public enum Orientation {
    N, E, S, W;

    public Orientation rotateRight() {
        return values()[(ordinal() + 1) % values().length];
    }

    public Orientation rotateLeft() {
        return values()[(ordinal() + 3) % values().length];
    }
}
