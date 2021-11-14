package com.nix.lpr.library.event;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

public class RestEntityAddEvent extends ApplicationEvent {
    private String message;
    private LocalDateTime timeStamp;

    public RestEntityAddEvent(Object object, String message, LocalDateTime timeStamp) {
        super(object);
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
