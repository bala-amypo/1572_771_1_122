// package com.example.demo.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;

// @Service
// public class UserServiceImpl implements UserService {

//     @Autowired
//     private UserRepository userRepository;

//     @Override
//     public User registerUser(User user) {

//         if (userRepository.existsByEmail(user.getEmail())) {
//             throw new RuntimeException("Email already exists");
//         }

//         // role defaults to MARKETER (screenshot rule)
//         if (user.getRole() == null) {
//             user.setRole("MARKETER");
//         }

//         return userRepository.save(user);
//     }

//     @Override
//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email); // ✅ FIXED
//     }
// }
