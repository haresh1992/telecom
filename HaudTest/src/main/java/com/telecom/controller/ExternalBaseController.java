package com.telecom.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The type External base controller.
 */
@ControllerAdvice
public class ExternalBaseController extends ResponseEntityExceptionHandler {

    /**
     * This will handle the exceptions
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        headers.set("error-msg", ex.getBindingResult().getFieldError().getDefaultMessage());
        headers.set("display-msg", ex.getBindingResult().getFieldError().getDefaultMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(null);
    }
}
