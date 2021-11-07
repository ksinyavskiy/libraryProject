package com.nix.lpr.library.exception.handler;

import com.nix.lpr.library.exception.entity.CustomRestApiException;
import com.nix.lpr.library.exception.entity.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;


@ControllerAdvice
public class CustomGlobalExceptionHandler {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleRestApiException(Exception e) {
        CustomRestApiException restApiException =
                new CustomRestApiException(e.getMessage(), HttpStatus.NOT_FOUND,
                        simpleDateFormat.format(Date.from(Instant.now())));
        return new ResponseEntity<>(restApiException, HttpStatus.NOT_FOUND);
    }
}
