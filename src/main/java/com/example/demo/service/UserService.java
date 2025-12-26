package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    // ✅ REQUIRED BY LOGIN TEST
    User findByEmail(String email);

    // ✅ REQUIRED BY REGISTER TEST
    User register(User user);
}
