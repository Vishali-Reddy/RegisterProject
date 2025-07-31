package com.RegisterProject.service;

import com.RegisterProject.payLoad.ApiResponse1;
import com.RegisterProject.payLoad.SingleResponse;
import com.RegisterProject.payLoad.UserPasswordDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogInOutService {

    public ApiResponse1 login(UserPasswordDTO userPasswordDTO) {
        UserPasswordDTO loginData=new UserPasswordDTO(
                userPasswordDTO.getUserName(),
                userPasswordDTO.getPassword()
        );
        ApiResponse1<UserPasswordDTO> obj1=new ApiResponse1<>(
                true,
                "login Successfully",
                LocalDateTime.now(),
                loginData
        );
        return obj1;
    }

    public ApiResponse1 logout(SingleResponse singleresponse) {
        SingleResponse logoutData=new SingleResponse(
                singleresponse.getUsername()
        );
        ApiResponse1<SingleResponse> obj2=new ApiResponse1<>(
                true,
                "logout Successfully",
                LocalDateTime.now(),
                logoutData
        );
        return obj2;
    }
}
