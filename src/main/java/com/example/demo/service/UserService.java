package com.example.demo.service;

import com.example.ROI.model.User;

public interface UserService {
    User registerUser(User user);
    User findByEmail(String email);

    
} 