package io.github.edsonzuchi.dolphin.core.exception;

public class OriginException extends RuntimeException {

    public static final OriginException NAME_IS_BLANK = new OriginException("Name is blank");

    public OriginException(String message) {
        super(message);
    }
}
