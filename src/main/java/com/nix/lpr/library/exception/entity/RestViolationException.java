package com.nix.lpr.library.exception.entity;

import java.util.List;

public class RestViolationException extends RuntimeException {
    private final List<String> errorMessages;

    public RestViolationException(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
