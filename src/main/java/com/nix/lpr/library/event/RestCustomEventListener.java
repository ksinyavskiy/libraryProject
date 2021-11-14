package com.nix.lpr.library.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class RestCustomEventListener implements ApplicationListener<RestEntityAddEvent> {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
    @Override
    public void onApplicationEvent(RestEntityAddEvent restEntityAddEvent) {
        System.out.println(String.format("The Add Entity event is received: %s, time: %s",
                restEntityAddEvent.getMessage(), dateTimeFormatter.format(restEntityAddEvent.getTimeStamp())));
    }
}
