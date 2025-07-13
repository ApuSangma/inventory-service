package com.InventoryManagement.controller.advice;


import com.InventoryManagement.exception.UserCustomException;
import com.InventoryManagement.model.response.CustomErrorResponse;
import com.InventoryManagement.model.response.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class AuthControllerAdvice {
    @ExceptionHandler(UserCustomException.class)
    public ResponseEntity<CustomErrorResponse> handleUserException(UserCustomException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                ex.getHttpStatus().getReasonPhrase(),
                ex.getMessage(),
                ex.getHttpStatus().toString(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorResponse>> handleValidationException(MethodArgumentNotValidException
                                                                                           ex) {

        List<ValidationErrorResponse> errorResponses = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> new ValidationErrorResponse(fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();
        return new ResponseEntity<>(errorResponses, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<CustomErrorResponse> handleUserException(AccessDeniedException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                ex.getMessage(),
                "YOU DON'T HAVE THE PERMISSION",
                HttpStatus.FORBIDDEN.toString(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }


}
