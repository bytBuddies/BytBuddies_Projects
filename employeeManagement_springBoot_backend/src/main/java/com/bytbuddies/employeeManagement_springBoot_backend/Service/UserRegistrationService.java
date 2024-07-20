package com.bytbuddies.employeeManagement_springBoot_backend.Service;

import com.bytbuddies.employeeManagement_springBoot_backend.Model.UserRegistration;

public interface UserRegistrationService {
    
    public UserRegistration userRegistration(UserRegistration data) throws Exception;

}
