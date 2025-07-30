package com.RegisterProject.exception;

import com.RegisterProject.payLoad.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandle {

//    @ExceptionHandler(EmployeeFoundException.class)
//    public ResponseEntity<Map<String, Object>> employeeFound(EmployeeFoundException exception, HttpServletRequest httpServletRequest){
//        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), exception.getStatusCode(), httpServletRequest.getRequestURL().toString());
//        Map<String,Object> errorResponse = new HashMap<>();
//        errorResponse.put("message",exception.getMessage());
//        errorResponse.put("statusCode", exception.getStatusCode());
//        errorResponse.put("URL", httpServletRequest.getRequestURL().toString());
//        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
//    }

    @ExceptionHandler(EmployeeFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleEmployeeFound(EmployeeFoundException ex, HttpServletRequest request) {
        ApiResponse<Object> response = new ApiResponse<>(
                false,
                "Registration failed",
                null,
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ApiResponse<Object> handleEmployeeNotFound(EmployeeNotFoundException ex, HttpServletRequest request) {
        ApiResponse<Object> response = new ApiResponse<>(
                false,
                "Registration failed",
                null,
                ex.getMessage()
        );
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        return response;
    }

    @ExceptionHandler(UserNameFoundException.class)
    public ApiResponse<Object> handleUserNameFound(UserNameFoundException ex, HttpServletRequest request) {
       return new ApiResponse<>(
                false,
                "Duplicate User Name",
                null,
                ex.getMessage()
        );
    }

    @ExceptionHandler(UserNameNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleUserNameNotFound(
            UserNameNotFoundException ex,
            HttpServletRequest request) {

        ApiResponse<Object> response = new ApiResponse<>(
                false,
                "User Name Not Found",
                null,
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(EmailFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleEmailFound(
            UserNameNotFoundException ex,
            HttpServletRequest request) {

        ApiResponse<Object> response = new ApiResponse<>(
                false,
                "User Name Not Found",
                null,
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
