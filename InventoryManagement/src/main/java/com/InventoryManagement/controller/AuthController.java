package com.InventoryManagement.controller;

import com.InventoryManagement.model.entity.UserBE;
import com.InventoryManagement.model.request.UserRequest;
import com.InventoryManagement.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class AuthController {
    @Autowired
    private final IUserService iUserService;

    public AuthController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserBE> addUser(@Valid @RequestBody UserRequest userRequest) {
        UserBE userBE = iUserService.addUser(userRequest);
        return new ResponseEntity<>(userBE, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserBE>> getAllUser() {
        List<UserBE> allUser = iUserService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<UserBE> getUserById(@PathVariable String id) {
        UserBE userById = iUserService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        boolean user = iUserService.deleteUser(id);
        if (!user) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
