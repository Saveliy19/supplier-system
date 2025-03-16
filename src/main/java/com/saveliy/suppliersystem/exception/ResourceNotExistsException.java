package com.saveliy.suppliersystem.exception;

public class ResourceNotExistsException extends RuntimeException {
    public ResourceNotExistsException(String message) {
        super(message);
    }
}
