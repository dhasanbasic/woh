package de.disoft.wor.util.enumeration;

public enum ErrorType {

    SYSTEM_ERROR(1, "The system has encountered"),
    CARD_REPOSITORY_ERROR(2, "Cards could not be loaded/parsed/saved.");

    private int code;
    private String message;

    ErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
