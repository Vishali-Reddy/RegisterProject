package com.RegisterProject.payLoad;


public class RegisterResponseDTO {
    private String employeeId;
    private String userName;
//    private String password;

    public RegisterResponseDTO() {}

    public RegisterResponseDTO(String employeeId, String userName) {
        this.employeeId = employeeId;
        this.userName = userName;
    }

//    public RegisterResponseDTO(String userName, String password) {
//        this.userName = userName;
//        this.password = password;
//    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

