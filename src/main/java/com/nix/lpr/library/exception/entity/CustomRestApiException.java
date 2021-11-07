package com.nix.lpr.library.exception.entity;

import org.springframework.http.HttpStatus;

public class CustomRestApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final String dateTimeStamp;

    public CustomRestApiException(String message, HttpStatus httpStatus, String dateTimeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.dateTimeStamp = dateTimeStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDateTimeStamp() {
        return dateTimeStamp;
    }
}
