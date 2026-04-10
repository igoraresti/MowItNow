package mowitnow.domain;

import java.util.List;

public class Mower {
    private Position position;
    private Orientation orientation;
    private final List<Instruction> instructions;

    public Mower(Position position, Orientation orientation, List<Instruction> instructions) {
        this.position = position;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public void executeInstructions(Lawn lawn) {
        for (Instruction instruction : instructions) {
            switch (instruction) {
                case A -> move(lawn);
                case L -> orientation = orientation.rotateLeft();
                case R -> orientation = orientation.rotateRight();
            }
        }
    }

    private void move(Lawn lawn) {
        Position nextPosition = position.move(orientation);
        if (lawn.isWithinBoundaries(nextPosition)) {
            position = nextPosition;
        }
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return position.x() + " " + position.y() + " " + orientation;
    }
}
