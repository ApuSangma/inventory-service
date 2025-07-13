package com.InventoryManagement.model.entity;

import com.InventoryManagement.model.enums.Role;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserBE {
    @NotNull
    private String id;
    @NotNull
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Role role;

    public UserBE() {
    }

    public UserBE(String id, String userName, String email, String password, Role role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
