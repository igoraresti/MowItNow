package mowitnow.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MowerTest {

    @Test
    @DisplayName("Mower should rotate left correctly")
    void rotateLeft() {
        Mower mower = new Mower(new Position(0, 0), Orientation.N, List.of());

        mower.executeInstructions(new Lawn(5, 5)); // No instructions, but just in case

        Mower mowerL = new Mower(new Position(0, 0), Orientation.N, List.of(Instruction.L));
        mowerL.executeInstructions(new Lawn(5, 5));
        assertThat(mowerL.getOrientation()).isEqualTo(Orientation.W);

        mowerL = new Mower(new Position(0, 0), Orientation.W, List.of(Instruction.L));
        mowerL.executeInstructions(new Lawn(5, 5));
        assertThat(mowerL.getOrientation()).isEqualTo(Orientation.S);
    }

    @ParameterizedTest
    @CsvSource({
        "N, L, W",
        "W, L, S",
        "S, L, E",
        "E, L, N",
        "N, R, E",
        "E, R, S",
        "S, R, W",
        "W, R, N"
    })
    void rotationTests(Orientation start, Instruction instruction, Orientation expected) {
        Mower mower = new Mower(new Position(0, 0), start, List.of(instruction));
        mower.executeInstructions(new Lawn(5, 5));
        assertThat(mower.getOrientation()).isEqualTo(expected);
    }

    @Test
    @DisplayName("Mower should move forward correctly")
    void moveForward() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Position(1, 2), Orientation.N, List.of(Instruction.A));
        mower.executeInstructions(lawn);
        assertThat(mower.getPosition()).isEqualTo(new Position(1, 3));
    }

    @Test
    @DisplayName("Mower should not move out of lawn boundaries")
    void moveOutOfBounds() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Position(5, 5), Orientation.N, List.of(Instruction.A));
        mower.executeInstructions(lawn);
        assertThat(mower.getPosition()).isEqualTo(new Position(5, 5));
        assertThat(mower.getOrientation()).isEqualTo(Orientation.N);

        Mower mowerSouth = new Mower(new Position(0, 0), Orientation.S, List.of(Instruction.A));
        mowerSouth.executeInstructions(lawn);
        assertThat(mowerSouth.getPosition()).isEqualTo(new Position(0, 0));
    }

    @Test
    @DisplayName("Complex movement sequence 1: 1 2 N LALALALAA -> 1 3 N")
    void complexSequence1() {
        Lawn lawn = new Lawn(5, 5);
        List<Instruction> instructions = "LALALALAA".chars()
                .mapToObj(c -> Instruction.fromChar((char) c))
                .toList();
        Mower mower = new Mower(new Position(1, 2), Orientation.N, instructions);
        mower.executeInstructions(lawn);
        assertThat(mower.getPosition()).isEqualTo(new Position(1, 3));
        assertThat(mower.getOrientation()).isEqualTo(Orientation.N);
    }

    @Test
    @DisplayName("Complex movement sequence 2: 3 3 E AARAARARRA -> 5 1 E")
    void complexSequence2() {
        Lawn lawn = new Lawn(5, 5);
        List<Instruction> instructions = "AARAARARRA".chars()
                .mapToObj(c -> Instruction.fromChar((char) c))
                .toList();
        Mower mower = new Mower(new Position(3, 3), Orientation.E, instructions);
        mower.executeInstructions(lawn);
        assertThat(mower.getPosition()).isEqualTo(new Position(5, 1));
        assertThat(mower.getOrientation()).isEqualTo(Orientation.E);
    }
}
