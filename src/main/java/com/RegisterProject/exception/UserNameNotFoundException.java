package com.RegisterProject.exception;

public class UserNameNotFoundException extends Exception{
    private String message;
    private String statusCode;

    public UserNameNotFoundException(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
