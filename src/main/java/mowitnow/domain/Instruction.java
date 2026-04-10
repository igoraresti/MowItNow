package mowitnow.domain;

public enum Instruction {
    A, L, R;

    public static Instruction fromChar(char c) {
        return valueOf(String.valueOf(c).toUpperCase());
    }
}
