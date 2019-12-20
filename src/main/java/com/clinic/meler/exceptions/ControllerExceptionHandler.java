package com.clinic.meler.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleProductNotFound(NotFoundException ex) {
        return new ErrorDto(ErrorCodes.NOT_FOUND.getErrorCode(), ex.getMessage());
    }

    @ExceptionHandler(InvalidArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleInvalidArgument(InvalidArgumentException ex) {
        return new ErrorDto(ErrorCodes.ARGUMENT_INVALID.getErrorCode(), ex.getMessage());
    }
}
