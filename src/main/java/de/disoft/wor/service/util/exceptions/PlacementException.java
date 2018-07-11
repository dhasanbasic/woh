package de.disoft.wor.service.util.exceptions;

public class PlacementException extends RuntimeException {

    public PlacementException() {
    }

    public PlacementException(String message) {
        super(message);
    }

    public PlacementException(Throwable cause) {
        super(cause);
    }

    public PlacementException(String message, Throwable cause) {
        super(message, cause);
    }

}
