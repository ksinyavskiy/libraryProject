package com.nix.lpr.library.exception.handler;

import com.nix.lpr.library.exception.entity.CustomRestApiException;
import com.nix.lpr.library.exception.entity.RestViolationException;
import com.nix.lpr.library.exception.entity.UserNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomGlobalExceptionHandler {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleRestApiException(Exception e) {
        CustomRestApiException restApiException =
                new CustomRestApiException(e.getMessage(), HttpStatus.NOT_FOUND,
                        simpleDateFormat.format(Date.from(Instant.now())));
        return new ResponseEntity<>(restApiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {RestViolationException.class})
    public ResponseEntity<Object> handleViolationException(RestViolationException restViolationException) {
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("errors", restViolationException.getErrorMessages());
        responseBody.put("status", HttpStatus.BAD_REQUEST);
        responseBody.put("timestamp", simpleDateFormat.format(Date.from(Instant.now())));

        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }
}
