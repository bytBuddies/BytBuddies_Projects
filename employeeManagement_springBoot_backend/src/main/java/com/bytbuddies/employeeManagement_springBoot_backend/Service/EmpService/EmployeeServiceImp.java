package com.bytbuddies.employeeManagement_springBoot_backend.Service.EmpService;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytbuddies.employeeManagement_springBoot_backend.Model.EmpModel.Employess;
import com.bytbuddies.employeeManagement_springBoot_backend.Repository.EmpRepository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    Logger logger = LoggerFactory.getLogger(EmployeeServiceImp.class);

    @Override
    public List<Employess> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employess addEmployee(Employess emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Employess putEmployess(Employess empData, String id) throws Exception {
        logger.info("putEmployee functions started!");
        Employess empResponse = null;
        try {
            Optional<Employess> empCheck = employeeRepository.findById(id);

            if (empCheck.isPresent()) {
                Employess empObj = empCheck.get();
                if (empData.getEmpFirstName() != null || !empData.getEmpFirstName().isEmpty()) {
                    empObj.setEmpFirstName(empData.getEmpFirstName());
                }
                empResponse = employeeRepository.save(empObj);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new Exception(e);
        }
        return empResponse;
    }

    @Override
    public Employess getEmployee(String id) throws Exception {
        logger.info("getEmployee function started!");
        Employess response = null;
        try {
            Optional<Employess> empResponse = employeeRepository.findById(id);
            if (empResponse.isPresent()) {
                response = empResponse.get();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new Exception(e);
        }
        logger.info("getEmployee function ended!");
        return response;
    }

    @Override
    public String removeEmployee(String id) throws Exception {
        try {
            logger.info("removeEmployee function started. serv");
            if (employeeRepository.findById(id).isPresent()) {
                employeeRepository.deleteById(id);
                return "Deleted.";
            } else
                return "Not Found";
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new Exception(e);
        }

    }
}
