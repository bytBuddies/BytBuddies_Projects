package com.bytbuddies.employeeManagement_springBoot_backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytbuddies.employeeManagement_springBoot_backend.Model.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, String>{
    
    public Optional<UserRegistration> findByEmail(String email);
}
