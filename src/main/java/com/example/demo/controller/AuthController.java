package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User u = userService.createUser(user);
        return ResponseEntity.status(201).body(u);
    }

    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        User existingUser = userService.findByEmail(user.getEmail());

        if (existingUser != null &&
            existingUser.getPassword().equals(user.getPassword())) {

            return ResponseEntity.status(200).body("Login Successful");
        } else {
            return ResponseEntity.status(401).body("Invalid Email or Password");
        }
    }
}
