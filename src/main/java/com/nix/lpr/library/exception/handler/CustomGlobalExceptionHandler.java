package com.nix.lpr.library.exception.handler;

import com.nix.lpr.library.exception.entity.RestApiException;
import com.nix.lpr.library.exception.entity.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleRestApiException(Exception e) {
        RestApiException restApiException =
                new RestApiException(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(restApiException, HttpStatus.NOT_FOUND);
    }
}
