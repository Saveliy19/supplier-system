package com.saveliy.suppliersystem.handler;

import com.saveliy.suppliersystem.exception.OverlappingPriceException;
import com.saveliy.suppliersystem.exception.ResourceAlreadyExistsException;
import com.saveliy.suppliersystem.exception.ResourceNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class DBExceptionsHandler {
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<String> resourceAlreadyExistsException(ResourceAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(OverlappingPriceException.class)
    public ResponseEntity<String> overlappingPriceException(OverlappingPriceException e) {
        List<String> conflicts = e.getOverlappingPrices().stream()
                .map(price -> "Price ID: " + price.id() +
                        ", Product ID: " + price.productId() +
                        ", Supplier ID: " + price.supplierId() +
                        ", Start Date: " + price.startDate() +
                        ", End Date: " + price.endDate())
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body("Price period overlaps with existing prices:\n" + String.join("\n", conflicts));
    }

    @ExceptionHandler(ResourceNotExistsException.class)
    public ResponseEntity<String> resourceNotExistsException(ResourceNotExistsException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
