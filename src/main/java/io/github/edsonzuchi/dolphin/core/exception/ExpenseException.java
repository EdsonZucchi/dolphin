package io.github.edsonzuchi.dolphin.core.exception;

public class ExpenseException extends RuntimeException {

    public static final ExpenseException VALUE_IS_NULL = new ExpenseException("Value is null");
    public static final ExpenseException DESCRIPTION_IS_BLANK = new ExpenseException("Description is blank");
    public static final ExpenseException DATE_INVALID = new ExpenseException("Date is invalid");

    public ExpenseException(String message) {
        super(message);
    }
}
