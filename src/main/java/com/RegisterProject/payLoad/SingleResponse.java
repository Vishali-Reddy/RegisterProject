package com.RegisterProject.payLoad;

public class SingleResponse {
    private String username;

    public SingleResponse(String username) {
        this.username = username;
    }

    public SingleResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
