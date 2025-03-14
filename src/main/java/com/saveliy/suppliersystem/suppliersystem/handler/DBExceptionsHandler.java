package com.saveliy.suppliersystem.suppliersystem.handler;

import com.saveliy.suppliersystem.suppliersystem.exception.ResourceAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DBExceptionsHandler {
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<String> resourceAlreadyExistsException(ResourceAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
