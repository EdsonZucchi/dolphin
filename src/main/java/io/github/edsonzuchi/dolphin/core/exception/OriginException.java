package io.github.edsonzuchi.dolphin.core.exception;

public class OriginException extends RuntimeException {

    public static final OriginException NAME_IS_BLANK = new OriginException("Name is blank");
    public static final OriginException ORIGIN_NOT_FOUND = new OriginException("Origin not found");

    public OriginException(String message) {
        super(message);
    }
}
