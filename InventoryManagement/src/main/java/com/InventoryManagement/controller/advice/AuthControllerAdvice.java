package com.InventoryManagement.controller.advice;

import com.InventoryManagement.exception.UserCustomException;
import com.InventoryManagement.model.response.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class AuthControllerAdvice {
    @ExceptionHandler(UserCustomException.class)
    public ResponseEntity<?> handleUserException(UserCustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
          ex.getHttpStatus().getReasonPhrase(),
          ex.getMessage(),
          ex.getHttpStatus().toString(),
          LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }



}
