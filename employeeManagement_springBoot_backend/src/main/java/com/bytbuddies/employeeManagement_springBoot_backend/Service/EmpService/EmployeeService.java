package com.bytbuddies.employeeManagement_springBoot_backend.Service.EmpService;

import java.util.List;

import com.bytbuddies.employeeManagement_springBoot_backend.Model.EmpModel.Employess;

public interface EmployeeService {
    public List<Employess> getAllEmp();

    public Employess addEmployee(Employess emp);

    public Employess putEmployess(Employess empData, String id) throws Exception;

    public Employess getEmployee(String id) throws Exception;

    public String removeEmployee(String id) throws Exception;
}
