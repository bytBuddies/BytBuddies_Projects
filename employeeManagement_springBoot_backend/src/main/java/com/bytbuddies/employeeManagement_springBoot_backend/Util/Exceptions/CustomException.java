package com.bytbuddies.employeeManagement_springBoot_backend.Util.Exceptions;

public class CustomException extends RuntimeException {
    
    public CustomException(String message) {
        super(message);
    }
}
