package com.InventoryManagement.controller;

import com.InventoryManagement.model.entity.UserBE;
import com.InventoryManagement.model.request.UserRequest;
import com.InventoryManagement.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class AuthController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("/register")
    public ResponseEntity<UserBE> addUser(@Valid @RequestBody UserRequest userRequest) {
        UserBE userBE = iUserService.addUser(userRequest);
        return new ResponseEntity<>(userBE, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserBE>> getAllUser() {
        List<UserBE> allUser = iUserService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBE> getUserById(@PathVariable String id) {
        UserBE userById = iUserService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        boolean user = iUserService.deleteUser(id);
        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
    }


}
