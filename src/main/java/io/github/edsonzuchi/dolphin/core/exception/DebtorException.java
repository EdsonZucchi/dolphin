package io.github.edsonzuchi.dolphin.core.exception;

public class DebtorException extends RuntimeException {

    public static final DebtorException NAME_IS_BLANK = new DebtorException("Name is blank");

    public DebtorException(String message) {
        super(message);
    }
}
