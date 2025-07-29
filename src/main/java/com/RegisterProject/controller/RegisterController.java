package com.RegisterProject.controller;

import com.RegisterProject.entity.Register;
import com.RegisterProject.exception.EmployeeFoundException;
import com.RegisterProject.payLoad.ApiResponse;
import com.RegisterProject.payLoad.RegisterResponseDTO;
import com.RegisterProject.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

//    @PostMapping("/add")
//    public ResponseEntity<Register> createRegister(@RequestBody Register register) {
//        Register savedRegister = registerService.createRegister(register); // assuming you have a service layer
//        return new ResponseEntity<>(savedRegister, HttpStatus.CREATED);
//    }
//    @PostMapping("/add/{employeeId}")
//    public ResponseEntity<Map<String,Object>> createRegister(@RequestBody Register register, @PathVariable String employeeId) throws EmployeeFoundException {
//        Register savedRegister = registerService.createRegister(register,employeeId);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("message", "User registered successfully");
//        response.put("data", obj);
//        response.put("status", HttpStatus.CREATED.value());
//        response.put("status",true);
//
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

    @PostMapping("/add/{employeeId}")
    public ApiResponse<RegisterResponseDTO> registerUser(
            @RequestBody Register register,
            @PathVariable String employeeId) throws EmployeeFoundException {
        Register savedRegister = registerService.createRegister(register, employeeId);

        RegisterResponseDTO responseData = new RegisterResponseDTO(
                savedRegister.getEmployeeId(),    // Assuming this is the database ID or employee ID
                savedRegister.getUserName()
        );

        ApiResponse<RegisterResponseDTO> response = new ApiResponse<>(
                true,
                "User registered successfully",
                responseData,
                null
        );

        return response;
    }

//    @GetMapping("/getAll")
//    public ResponseEntity<List<Register>> getRegister() {
//        List<Register> savedRegister = registerService.getRegister(); // assuming you have a service layer
//        return new ResponseEntity<>(savedRegister, HttpStatus.OK);
//    }


//    @GetMapping("/getAll")
//    public ResponseEntity<Map<String,Object>> getRegister() {
//        List<Register> savedRegister = registerService.getRegister(); // assuming you have a service layer
//        Map<String,Object> response = new HashMap<>();
//        response.put(",message","List of Employees are retrieved successfully");
//        response.put("data",savedRegister);
//        response.put("status",HttpStatus.OK.value());
//        response.put("status",true);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
    @GetMapping("/getAll")
    public ApiResponse<List<RegisterResponseDTO>> getRegister(){
        List<Register> getAllRegisters = registerService.getRegister();

        List<RegisterResponseDTO> responseList = new ArrayList<>();
        for (Register reg : getAllRegisters) {
            RegisterResponseDTO dto = new RegisterResponseDTO(
                    reg.getEmployeeId(),    // or reg.getId() based on your model
                    reg.getUserName()
            );
            responseList.add(dto);
        }
        return new ApiResponse<>(
                true,
                "Users fetched successfully",
                responseList,
                null
        );

    }

//    @GetMapping("/getId/{employeeId}")
//    public ResponseEntity<Register> getEmpById(@PathVariable String employeeId) {
//        Register savedRegister = registerService.getEmpById(employeeId); // assuming you have a service layer
//        return new ResponseEntity<>(savedRegister, HttpStatus.OK);
//    }


//    @GetMapping("/getId/{employeeId}")
//    public ResponseEntity<Map<String,Object>> getEmpById(@PathVariable String employeeId) {
//        Register savedRegister = registerService.getEmpById(employeeId); // assuming you have a service layer
//        Map<String, Object> response = new HashMap<>();
//
//        response.put("message","Employee "+employeeId+" is retrieved successfully");
//        response.put("data",savedRegister);
//        response.put("status",HttpStatus.OK.value());
//        response.put("status",true);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }


    @GetMapping("/getId/{employeeId}")
    public ApiResponse<RegisterResponseDTO> getEmpById(@PathVariable String employeeId){
        Register getEmp = registerService.getEmpById(employeeId);

        RegisterResponseDTO responseDTO = new RegisterResponseDTO(
                getEmp.getEmployeeId(),
                getEmp.getUserName()
        );
        return new ApiResponse<>(
                true,
                "Employee retrived successfully",
                responseDTO,
                null
        );
    }

//    @DeleteMapping("/delete/{employeeId}")
//    public ResponseEntity<Map<String,Object>> deleteEmpById(@PathVariable String employeeId) {
//        String deleteResponse = registerService.deleteEmpById(employeeId);
//        Map<String, Object> response = new HashMap<>();
//
//        response.put("message","Employee "+employeeId+" is deleted successfully");
//        response.put("data",deleteResponse);
//        response.put("status",HttpStatus.OK.value());
//        response.put("status",true);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @DeleteMapping("/delete/{employeeId}")
    public ApiResponse<RegisterResponseDTO> deleteEmpById(@PathVariable String employeeId) {
        String deleteResponse = registerService.deleteEmpById(employeeId);
       RegisterResponseDTO responseDTO = new RegisterResponseDTO(
               employeeId,
               null
       );
       return new ApiResponse<>(
               true,
               "Employee is deleted successfully",
               responseDTO,
               null
       );
    }



//    @PutMapping("/update/{employeeId}")
//    public ResponseEntity<Map<String,Object>> updateEmpById(@RequestBody Register register, @PathVariable String employeeId) {
//        Register savedRegister = registerService.updateEmpById(register, employeeId); // assuming you have a service layer
//            Map<String, Object> response = new HashMap<>();
//
//            response.put("message","Employee "+employeeId+" is updated successfully");
//            response.put("data",savedRegister);
//            response.put("status",HttpStatus.OK.value());
//            response.put("status",true);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @PutMapping("/update/{employeeId}")
    public ApiResponse<RegisterResponseDTO> updateEmpById(@RequestBody Register register, @PathVariable String employeeId) {
        Register savedRegister = registerService.updateEmpById(register, employeeId); // assuming you have a service layer

        RegisterResponseDTO responseDTO = new RegisterResponseDTO(
                savedRegister.getEmployeeId(),
                savedRegister.getUserName());
         return new ApiResponse<>(
                 true,
                 "Employee details are successfully updated",
                 responseDTO,
                 null
         );
    }


//    @PatchMapping("/patch/{employeeId}")
//    public ResponseEntity<Map<String,Object>> partiallyUpdateEmpById(@RequestBody Register register, @PathVariable String employeeId) {
//        Register savedRegister = registerService.partiallyUpdateEmpById(register, employeeId); // assuming you have a service layer
//        Map<String, Object> response = new HashMap<>();
//
//        response.put("message","Employee "+employeeId+" is updated successfully");
//        response.put("data",savedRegister);
//        response.put("status",HttpStatus.OK.value());
//        response.put("status",true);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @PatchMapping("/patch/{employeeId}")
    public ApiResponse<RegisterResponseDTO> partiallyUpdateEmpById(@RequestBody Register register, @PathVariable String employeeId) {
        Register savedRegister = registerService.partiallyUpdateEmpById(register, employeeId); // assuming you have a service layer
        RegisterResponseDTO responseDTO = new RegisterResponseDTO(
                savedRegister.getEmployeeId(),
                savedRegister.getUserName());
        return new ApiResponse<>(
                true,
                "Employee details are successfully updated",
                responseDTO,
                null
        );
    }

//    @GetMapping("/getId/{employeeId}")
//    public Map<String,Object> getEmpById(@PathVariable String employeeId) {
//        Register savedRegister = registerService.getEmpById(employeeId); // assuming you have a service layer
//        Map<String, Object> response = new HashMap<>();
//
//        response.put("message","Employee "+employeeId+" is retrieved successfully");
//        response.put("data",savedRegister);
//        response.put("status",HttpStatus.OK.value());
//
//        return response;
//    }

}


