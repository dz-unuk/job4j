package ru.job4j.chess.figures;

public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
