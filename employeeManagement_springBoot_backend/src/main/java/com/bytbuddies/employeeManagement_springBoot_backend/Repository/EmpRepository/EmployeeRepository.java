package com.bytbuddies.employeeManagement_springBoot_backend.Repository.EmpRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytbuddies.employeeManagement_springBoot_backend.Model.EmpModel.Employess;

@Repository
public interface EmployeeRepository extends JpaRepository<Employess, String>{
    
}
