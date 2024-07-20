package com.bytbuddies.employeeManagement_springBoot_backend.Controller.RegistrationController;

import java.net.http.HttpRequest;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytbuddies.employeeManagement_springBoot_backend.Model.UserRegistration;
import com.bytbuddies.employeeManagement_springBoot_backend.Service.UserRegistrationService;

@RestController
@RequestMapping("v1/api/ems/user")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService urService;
    Logger log = LoggerFactory.getLogger(UserRegistrationController.class);

    /**
     * Rest Contrller function for new user registration
     * 
     * @param data holds required details for registration like username password
     *             email...
     * @return new registered user
     * @throws Exception
     */
    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HashMap<String, String>> userRegister(@RequestBody UserRegistration data) throws Exception {
        log.info("userRegister function started!");
        HashMap<String, String> response = new HashMap<>();
        try {
            urService.userRegistration(data);
            response.put("email", data.getEmail());
            response.put("first_name", data.getFirstName());
            response.put("last_name", data.getLastName());
        } catch (Exception e) {
            log.error(e.getMessage());
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("userRegister function ended!");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    
}
