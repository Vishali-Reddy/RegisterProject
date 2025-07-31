package com.RegisterProject.controller;

import com.RegisterProject.payLoad.ApiResponse1;
import com.RegisterProject.payLoad.SingleResponse;
import com.RegisterProject.payLoad.UserPasswordDTO;
import com.RegisterProject.service.LogInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInOutController {

    @Autowired
    private LogInOutService logInOutService;

    @PostMapping("/login")
    public ApiResponse1 loginUser(@RequestBody UserPasswordDTO userPasswordDTO) {
        return logInOutService.login(userPasswordDTO);
    }

    @PostMapping("/logout")
    public ApiResponse1 logoutUser(@RequestBody SingleResponse singleresponse) {
        return logInOutService.logout(singleresponse);
    }
}
