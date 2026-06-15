package com.ecommerce.smartcart.dto;

public class ApiResponse {

    private String message;
    private boolean hasError;

    public ApiResponse() {
    }

    public ApiResponse(String message, boolean hasError) {
        this.message = message;
        this.hasError = hasError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }
}