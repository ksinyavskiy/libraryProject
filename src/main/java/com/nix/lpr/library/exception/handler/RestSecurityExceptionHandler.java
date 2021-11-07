package com.nix.lpr.library.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nix.lpr.library.exception.entity.CustomRestApiException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;

@Component
public class RestSecurityExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException {
        CustomRestApiException customRestApiException =
                new CustomRestApiException("Invalid credentials, access denied!", HttpStatus.FORBIDDEN,
                        simpleDateFormat.format(Date.from(Instant.now())));

        prepareResponseData(httpServletResponse, customRestApiException);
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException {
        CustomRestApiException customRestApiException =
                new CustomRestApiException("User has no access to the requested resource", HttpStatus.FORBIDDEN,
                        simpleDateFormat.format(Date.from(Instant.now())));

        prepareResponseData(httpServletResponse, customRestApiException);
    }

    private void prepareResponseData(HttpServletResponse httpServletResponse,
                                     CustomRestApiException customRestApiException) throws IOException {
        httpServletResponse.setContentType("application/json");

        OutputStream outputStream = httpServletResponse.getOutputStream();
        OBJECT_MAPPER.writeValue(outputStream, customRestApiException);

        outputStream.flush();
        outputStream.close();
    }
}
