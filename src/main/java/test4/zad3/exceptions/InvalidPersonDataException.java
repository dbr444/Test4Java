package test4.zad3.exceptions;

public class InvalidPersonDataException extends RuntimeException {
    public InvalidPersonDataException(String message) {
        super(message);
    }
}

