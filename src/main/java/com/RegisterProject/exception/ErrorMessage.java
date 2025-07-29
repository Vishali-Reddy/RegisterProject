package com.RegisterProject.exception;

public class ErrorMessage
{
    private String message;
    private String statusCode;
    private String url;

    public ErrorMessage(String message, String statusCode, String url) {
        this.message = message;
        this.statusCode = statusCode;
        this.url = url;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
