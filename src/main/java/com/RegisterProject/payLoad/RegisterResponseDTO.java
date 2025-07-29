package com.RegisterProject.payLoad;


public class RegisterResponseDTO {
    private String id;
    private String username;

    public RegisterResponseDTO() {}

    public RegisterResponseDTO(String id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

