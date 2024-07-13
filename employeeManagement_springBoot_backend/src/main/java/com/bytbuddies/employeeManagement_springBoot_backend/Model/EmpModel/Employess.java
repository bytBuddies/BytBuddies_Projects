package com.bytbuddies.employeeManagement_springBoot_backend.Model.EmpModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "employee_details")
public class Employess {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "emp_first_name", length = 20)
    private String empFirstName;

    @Column(name = "emp_second_name", length = 20)
    private String empSecondName;

    @Column(name = "emp_phone1")
    private Long empPhone1;

    public Employess(){}

    public Employess(String empFirstName, String empSecondName, Long empPhone1) {
        this.empFirstName = empFirstName;
        this.empSecondName = empSecondName;
        this.empPhone1 = empPhone1;
    }

    
    public String getId() {
        return id;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getempSecondName() {
        return empSecondName;   
    }

    public void setempSecondName(String empSecondName) {
        this.empSecondName = empSecondName;
    }

    public Long getEmpPhone1() {
        return empPhone1;
    }

    public void setEmpPhone1(Long empPhone1) {
        this.empPhone1 = empPhone1;
    }
}
