package de.disoft.wor.util.exception;

import de.disoft.wor.util.enumeration.ErrorType;

public class WorTechnicalException extends RuntimeException {

    public WorTechnicalException(ErrorType errorType, Throwable cause) {
        super(errorType.getMessage(), cause);
    }

}
