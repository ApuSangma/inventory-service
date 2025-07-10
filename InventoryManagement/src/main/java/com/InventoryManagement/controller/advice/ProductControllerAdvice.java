package com.InventoryManagement.controller.advice;

import com.InventoryManagement.exception.ProductCustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductCustomException.class)
    public ResponseEntity<?> handleUserException(ProductCustomException ex) {
        return null;
    }
}
