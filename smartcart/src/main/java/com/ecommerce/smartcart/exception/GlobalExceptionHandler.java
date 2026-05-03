/*
 * package com.ecommerce.smartcart.exception;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.web.bind.MethodArgumentNotValidException; import
 * org.springframework.web.bind.annotation.*;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * @RestControllerAdvice public class GlobalExceptionHandler {
 * 
 * @ExceptionHandler(MethodArgumentNotValidException.class)
 * 
 * @ResponseStatus(HttpStatus.BAD_REQUEST) public Map<String, String>
 * handleValidationExceptions(MethodArgumentNotValidException ex) {
 * 
 * Map<String, String> errors = new HashMap<>();
 * 
 * ex.getBindingResult().getFieldErrors().forEach(error ->
 * errors.put(error.getField(), error.getDefaultMessage()) );
 * 
 * return errors; } }
 */


package com.ecommerce.smartcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Validation errors
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return errors;
    }

    // Custom exception

      @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleResourceNotFound(ResourceNotFoundException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());

        return error;
    }

    // Generic exception (fallback)
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleGenericException(Exception ex) {

        Map<String, String> error = new HashMap<>();
        error.put("message", "Something went wrong");

        return error;
    }
}