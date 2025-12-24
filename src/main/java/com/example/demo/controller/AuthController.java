// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     // POST /auth/register
//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestBody User user) {
//         User savedUser = userService.registerUser(user);
//         return ResponseEntity.status(201).body(savedUser);
//     }

//     // POST /auth/login
//     @PostMapping("/login")
//     public ResponseEntity<String> login(@RequestBody User user) {

//         User existingUser = userService.findByEmail(user.getEmail());

//         if (existingUser == null) {
//             return ResponseEntity.status(401).body("Invalid Email or Password");
//         }

//         if (!existingUser.getPassword().equals(user.getPassword())) {
//             return ResponseEntity.status(401).body("Invalid Email or Password");
//         }

//         return ResponseEntity.ok("Login Successful");
//     }
// }
