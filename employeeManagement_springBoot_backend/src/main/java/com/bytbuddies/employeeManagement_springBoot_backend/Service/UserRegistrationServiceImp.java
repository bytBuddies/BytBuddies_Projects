package com.bytbuddies.employeeManagement_springBoot_backend.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytbuddies.employeeManagement_springBoot_backend.Model.UserRegistration;
import com.bytbuddies.employeeManagement_springBoot_backend.Repository.UserRegistrationRepository;
import com.bytbuddies.employeeManagement_springBoot_backend.Util.UtilEnums;
import com.bytbuddies.employeeManagement_springBoot_backend.Util.Exceptions.CustomException;

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
    @Transactional
    public Boolean userRegistration(UserRegistration data) throws Exception {
        log.info("userRegistration function started!");
        try {
            boolean userExists = urRepository.findByEmail(data.getEmail()).isPresent();
            if (userExists) {
                log.warn("Email already exists: {}", data.getEmail());
                throw new CustomException("Email Address already exists.");
            }
            if (!data.getPassword().equals(data.getPassword2())) {
                log.warn("Password mismatch for email: {}", data.getEmail());
                throw new CustomException("Confirm password does not match password.");
            }
            // Passwords match, proceeding to encode and save the user
            data.setPassword(passwordEncoder.encode(data.getPassword()));
            data.setEmailVarified(false);
            data.setIsFirstLogin(true);
            data.setRoleId(UtilEnums.ORG_ADMIN.getValue());
            data.setCreatedAt();
            urRepository.save(data);
            log.info("userRegistration function ended!");
            return data.getEmailVarified();
        } catch (DataIntegrityViolationException e) {
            log.error("Data integrity violation occurred: ", e);
            throw new Exception("Data integrity violation: " + e.getRootCause().getMessage(), e);
        } catch (Exception e) {
            log.error("Exception occurred during user registration: ", e);
            throw e;
        }

    }

}
