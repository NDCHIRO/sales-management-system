package com.sales.management;

import com.sales.management.model.generic.ErrorServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Handle general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorServiceResponse> handleGlobalException(Exception ex, WebRequest request) {
        // Log the exception (optional)
        ex.printStackTrace();
        // Create the custom error response
        ErrorServiceResponse errorResponse = new ErrorServiceResponse();
        errorResponse.setReference(UUID.randomUUID().toString());
        errorResponse.setCode("-1");
        errorResponse.setDescription("operation not available");
        errorResponse.setArabicMessage("حدث مشكله");
        errorResponse.setEnglishMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        // Return a generic error message
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // You can add more specific handlers for different exception types if needed
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>("Invalid input provided: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}