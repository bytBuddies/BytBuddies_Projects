package com.bytbuddies.employeeManagement_springBoot_backend.Model;

import java.sql.Timestamp;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Valid
@Table(name="user_register")
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull(message = "Email can't be null")
    @NotEmpty(message = "Email can't be empty")
    @NotBlank(message = "Email can't be blank")
    @Email(message = "Not a valid email")
    @Column(name = "email", length = 100)
    private String email;

    @NotNull(message = "Password can't be null")
    @NotEmpty(message = "Password can't be empty")
    @NotBlank(message = "Password can't be blank")
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Transient
    @NotNull(message = "Confirm Password can't be null")
    @NotEmpty(message = "Confirm Password can't be empty")
    @NotBlank(message = "Confirm Password can't be blank")
    private String password2;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @NotNull(message = "First name can't be null")
    @NotEmpty(message = "First name can't be empty")
    @NotBlank(message = "First name can't be blank")
    @Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    @NotNull(message = "Last name can't be null")
    @NotEmpty(message = "Last name can't be empty")
    @NotBlank(message = "Last name can't be blank")
    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;

    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Column(name = "is_first_login", nullable = true)
    private Boolean isFirstLogin;

    @Column(name = "role_id", nullable = true, length = 255)
    private String roleId;

    @Column(name = "email_varified", nullable = false)
    private Boolean emailVarified;

    public UserRegistration() {
    }

    public UserRegistration(String email, String password, Long phone, String firstName,
            String lastName, Boolean isFirstLogin, String roleId, Boolean emailVarified) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isFirstLogin = isFirstLogin;
        this.roleId = roleId;
        this.emailVarified = emailVarified;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getEmailVarified() {
        return emailVarified;
    }

    public void setEmailVarified(Boolean emailVarified) {
        this.emailVarified = emailVarified;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getIsFirstLogin() {
        return isFirstLogin;
    }

    public void setIsFirstLogin(Boolean isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    public String getId() {
        return id;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public String getRoleId() {
        return roleId;
    }
}
