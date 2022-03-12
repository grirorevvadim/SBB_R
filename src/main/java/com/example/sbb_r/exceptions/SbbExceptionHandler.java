package com.example.sbb_r.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class SbbExceptionHandler {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity <Object> handleEntityNotFoundException(EntityNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(),new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
