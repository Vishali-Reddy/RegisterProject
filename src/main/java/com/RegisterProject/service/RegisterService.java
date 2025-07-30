package com.RegisterProject.service;

import com.RegisterProject.entity.Register;
import com.RegisterProject.exception.EmailFoundException;
import com.RegisterProject.exception.EmployeeFoundException;
import com.RegisterProject.exception.UserNameFoundException;
import com.RegisterProject.exception.UserNameNotFoundException;
import com.RegisterProject.payLoad.RegisterResponseDTO;
import com.RegisterProject.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterService {
    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Register createRegister(Register register) throws EmployeeFoundException, UserNameFoundException, EmailFoundException {
       if (registerRepository.findByEmployeeId(register.getEmployeeId()) != null) {
        throw new EmployeeFoundException("The Employee ID is already registered.", String.valueOf(HttpStatus.FOUND.value()));
    }

    if (registerRepository.findByUserName(register.getUserName()) != null) {
        throw new UserNameFoundException("The username is already taken.", String.valueOf(HttpStatus.FOUND.value()));
    }

    if (registerRepository.findByEmail(register.getEmail()) != null) {
        throw new EmailFoundException("The email is already registered.", String.valueOf(HttpStatus.FOUND.value()));
    }

    String encryptedPassword = passwordEncoder.encode(register.getPassword());
    register.setPassword(encryptedPassword);


    return registerRepository.save(register);
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

    public Register getUserName(String userName) throws UserNameNotFoundException {
        Register register = registerRepository.findByUserName(userName);

        if(register==null){
            throw new UserNameNotFoundException("Employee with given user not found",String.valueOf(HttpStatus.FOUND.value()));
        }
        else{
            return register;
        }
    }
}
