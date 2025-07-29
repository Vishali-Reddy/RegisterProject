package com.RegisterProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity
public class Register {
    @Id
    private String employeeId;
    private String userName;
    private String email;
    private String password;
    private Long mobileNumber;
//    private LocalDateTime  registerTime;

//    @PrePersist
//    protected void onRegister() {
//        this.registerTime = LocalDateTime.now();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

//    public LocalDateTime getRegisterTime() {
//        return registerTime;
//    }
//
//    public void setRegisterTime(LocalDateTime registerTime) {
//        this.registerTime = registerTime;
//    }
}
