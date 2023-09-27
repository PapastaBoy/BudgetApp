package Exceptions;

/**
 * Extends {@link Exception} to allow for a custom exception clause
 * for when an amount given to a method is outwith the bounds of
 * the function
 * @see java.lang.Exception
 */
public class InvalidAmountException extends Exception {
    public InvalidAmountException(String errorMessage) {
        super(errorMessage);
    }
}
