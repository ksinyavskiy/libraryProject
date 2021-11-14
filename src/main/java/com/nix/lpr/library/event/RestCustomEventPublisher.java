package com.nix.lpr.library.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RestCustomEventPublisher {

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public RestCustomEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void sendCreateEntityEvent(String message) {
        RestEntityAddEvent restEntityAddEvent = new RestEntityAddEvent(this, message, LocalDateTime.now());
        applicationEventPublisher.publishEvent(restEntityAddEvent);
    }
}
