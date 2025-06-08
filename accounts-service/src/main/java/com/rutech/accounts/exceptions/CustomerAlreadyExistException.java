package com.rutech.accounts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistException extends RuntimeException {

    public CustomerAlreadyExistException() {
        super();
    }

    public CustomerAlreadyExistException(String message) {
        super(message);
    }

    public CustomerAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerAlreadyExistException(Throwable cause) {
        super(cause);
    }

    protected CustomerAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
