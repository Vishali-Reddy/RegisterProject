package com.RegisterProject.payLoad;


public class RegisterResponseDTO {
    private String employeeId;
    private String username;

    public RegisterResponseDTO() {}

    public RegisterResponseDTO(String employeeId, String username) {
        this.employeeId = employeeId;
        this.username = username;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

