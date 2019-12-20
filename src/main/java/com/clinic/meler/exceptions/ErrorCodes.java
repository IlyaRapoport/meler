package com.clinic.meler.exceptions;

public enum ErrorCodes {
    NOT_FOUND("1"),
    ARGUMENT_INVALID("2");

    private String errorCode;

    ErrorCodes(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
