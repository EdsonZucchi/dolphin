package io.github.edsonzuchi.dolphin.core.exception;

public class DebtorException extends RuntimeException {

    public static final DebtorException NAME_IS_BLANK = new DebtorException("Name is blank");
    public static final DebtorException DEBTOR_NOT_FOUND = new DebtorException("Debtor not found");

    public DebtorException(String message) {
        super(message);
    }
}
