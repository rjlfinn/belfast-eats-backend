package com.belfasteats.restaurants.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidParametersException extends RuntimeException {
    public InvalidParametersException() {
        super();
    }
    public InvalidParametersException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidParametersException(String message) {
        super(message);
    }
    public InvalidParametersException(Throwable cause) {
        super(cause);
    }
}
