package test4.zad1.exceptions;

public class InvalidPeselException extends RuntimeException {
    public InvalidPeselException(String message) {
        super(message);
    }
}
