package com.bytbuddies.employeeManagement_springBoot_backend.Service;

import java.security.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bytbuddies.employeeManagement_springBoot_backend.Model.UserRegistration;
import com.bytbuddies.employeeManagement_springBoot_backend.Repository.UserRegistrationRepository;
import com.bytbuddies.employeeManagement_springBoot_backend.Util.UtilEnums;

@Service
public class UserRegistrationServiceImp implements UserRegistrationService {

    @Autowired
    private UserRegistrationRepository urRepository;
    Logger log = LoggerFactory.getLogger(UserRegistrationService.class);
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * User Registration function which use to register new user and send
     * notification to varify email address.
     * 
     * @param userRegistration hold required key values like username password
     *                         email...
     * @return added user with 201 response code.
     */
    @Override
    public UserRegistration userRegistration(UserRegistration data) throws Exception {
        log.info("userRegistration function started!");
        UserRegistration user = new UserRegistration();
        try {
            Boolean userCheck = urRepository.findByEmail(data.getEmail()).isPresent();
            if (!userCheck) {
                if (data.getPassword().equals(data.getPassword2())) {
                    String encodPassword = passwordEncoder.encode(data.getPassword());
                    user.setPassword(encodPassword);
                    user.setEmail(data.getEmail());
                    user.setFirstName(data.getFirstName());
                    user.setLastName(data.getLastName());

                    if (data.getPhone() != null)
                        user.setPhone(data.getPhone());

                    user.setRoleId(UtilEnums.ORG_ADMIN.getValue());
                    user.setEmailVarified(false);
                    user.setIsFirstLogin(true);
                    user.setCreatedAt();
                    urRepository.save(user);
                } else
                    throw new Exception("Confirm password not matching with password.");
            } else {
                throw new Exception("Email Address Already exists.");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e);
        }
        log.info("userRegistration function ended!");
        return user;
    }

}
