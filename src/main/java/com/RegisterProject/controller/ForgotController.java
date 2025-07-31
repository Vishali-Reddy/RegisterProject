package com.RegisterProject.controller;

import com.RegisterProject.payLoad.ForgotPasswordDto;
import com.RegisterProject.payLoad.forgotPassword;
import com.RegisterProject.service.ForgotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForgotController {

    @Autowired
    private ForgotService forgotPasswordService;

    @PostMapping("/request")
    public ResponseEntity<String> requestReset(@RequestBody forgotPassword request) {
        String response = forgotPasswordService.initiateReset(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody ForgotPasswordDto request) {
        String response = forgotPasswordService.resetPassword(request);
        return ResponseEntity.ok(response);
    }
}
