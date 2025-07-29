package com.RegisterProject.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(EmployeeFoundException.class)
    public ResponseEntity<Map<String, Object>> employeeFound(EmployeeFoundException exception, HttpServletRequest httpServletRequest){
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), exception.getStatusCode(), httpServletRequest.getRequestURL().toString());
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("message",exception.getMessage());
        errorResponse.put("statusCode", exception.getStatusCode());
        errorResponse.put("URL", httpServletRequest.getRequestURL().toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }


}
