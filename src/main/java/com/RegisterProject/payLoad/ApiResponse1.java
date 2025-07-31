package com.RegisterProject.payLoad;
import java.time.LocalDateTime;

public class ApiResponse1<T> {
    private boolean status;
    private String message;
    private LocalDateTime timestamp;
    private T Data;

    public ApiResponse1(boolean status, String message, LocalDateTime timestamp, T data) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        Data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public ApiResponse1() {
    }
}

