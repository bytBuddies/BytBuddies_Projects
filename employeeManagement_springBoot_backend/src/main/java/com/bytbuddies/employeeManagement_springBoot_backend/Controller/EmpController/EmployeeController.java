package com.bytbuddies.employeeManagement_springBoot_backend.Controller.EmpController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytbuddies.employeeManagement_springBoot_backend.Model.EmpModel.Employess;
import com.bytbuddies.employeeManagement_springBoot_backend.Service.EmpService.EmployeeService;

@RestController
@RequestMapping("v1/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping(value = "/", produces = "application/json")
    public List<Employess> getAllEmployees() {
        return employeeService.getAllEmp();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employess> addEmployee(@RequestBody Employess employee) throws Exception {
        logger.info("addEmployee function started!");
        Employess empResponse = null;
        try {
            empResponse = employeeService.addEmployee(employee);
        } catch (Exception e) {
            logger.error("Error while adding employee", e.getMessage());
            throw new Exception(e);
        }
        logger.info("addEmployee function ended!");
        return new ResponseEntity<>(empResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employess> putEmployee(@RequestBody Employess emp, @PathVariable("id") String id)
            throws Exception {
        logger.info("putEmployee function started!");
        Employess empResponse = null;
        try {
            empResponse = employeeService.putEmployess(emp, id);
        } catch (Exception e) {
            logger.error("Error while adding employee", e.getMessage());
            throw new Exception(e);
        }
        logger.info("putEmployee function ended!");
        return new ResponseEntity<>(empResponse, HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Employess> getEmployee(@PathVariable String id) throws Exception {
        logger.info("getEmployee function started!");
        Employess response = null;
        try {
            response = employeeService.getEmployee(id);
        } catch (Exception e) {
            logger.error("Error while adding employee", e.getMessage());
            throw new Exception(e);
        }
        logger.info("getEmployee function started!");
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public String removeEmployee(@PathVariable String id) throws Exception {
        logger.info("removeEmployee function started"); 
        String response = null;
        try {
            response = employeeService.removeEmployee(id);
        } catch (Exception e) {
            logger.error("Error while adding employee", e.getMessage());
            throw new Exception(e);
        }
        logger.info("removeEmployee function ended");
        return response;
    }
}
