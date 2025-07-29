package com.RegisterProject.service;

import com.RegisterProject.entity.Register;
import com.RegisterProject.exception.EmployeeFoundException;
import com.RegisterProject.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterService {
    @Autowired
    RegisterRepository registerRepository;


    public Register createRegister(Register register, String employeeId) throws EmployeeFoundException {
        Register reg = registerRepository.findByEmployeeId(employeeId);
        if(reg!=null)
        {
            throw new EmployeeFoundException("The Employee is Already Registered...", String.valueOf(HttpStatus.FOUND.value()));
        }
        else {
            register.setEmployeeId(employeeId);
            return registerRepository.save(register);
        }
    }


    public List<Register> getRegister() {
        return registerRepository.findAll();
    }

    public Register getEmpById(String employeeId) {
        return registerRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
    }

    public String deleteEmpById(String employeeId) {
        registerRepository.deleteById(employeeId);
        return "Employee with "+employeeId+" has been deleted";
    }


    public Register updateEmpById(Register register, String employeeId) {
        Register reg =registerRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
        reg.setUserName(register.getUserName());
        reg.setEmail(register.getEmail());
        reg.setMobileNumber(register.getMobileNumber());
        reg.setPassword(register.getPassword());

        return registerRepository.save(reg);
    }

    public Register partiallyUpdateEmpById(Register register, String employeeId) {
        Register existing =registerRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
        if (register.getUserName() != null) {
            existing.setUserName(register.getUserName());
        }
        if (register.getEmail() != null) {
            existing.setEmail(register.getEmail());
        }
        if (register.getMobileNumber() != null) {
            existing.setMobileNumber(register.getMobileNumber());
        }
        if (register.getPassword() != null) {
            existing.setPassword(register.getPassword());
        }

        return registerRepository.save(existing);
    }
}
