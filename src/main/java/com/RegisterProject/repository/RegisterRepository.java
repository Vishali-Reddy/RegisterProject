package com.RegisterProject.repository;

import com.RegisterProject.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, String> {

    String deleteByEmployeeId(String employeeId);
    Register findByEmployeeId(String employeeId);

    Register findByUserName(String userName);

    Register findByEmail(String email);
//    Register partiallyUpdateEmpId(Register register, String employeeId);
}
