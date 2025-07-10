package com.InventoryManagement.model.request;

import com.InventoryManagement.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 100)
    private String userName;

    @NotNull
    @Email
    @NotBlank
    @Size(min =3, max = 50)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String password;

    @NotNull
    private Role role;

    public UserRequest() {
    }

    public UserRequest(String email, String password, Role role, String userName) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
