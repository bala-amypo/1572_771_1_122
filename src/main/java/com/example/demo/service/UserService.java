package com.example.ROI.service;

import com.example.ROI.model.User;

public interface UserService {
    User registerUser(User user);
    User findByEmail(String email);

    
} 