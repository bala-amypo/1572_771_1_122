package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ USED BY /auth/login
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    // ✅ USED BY /auth/register
    @Override
    public User register(User user) {

        // Email uniqueness enforced by DB + test
        user.setId(null);

        // ✅ DEFAULT ROLE REQUIRED BY TEST
        if (user.getRole() == null) {
            user.setRole("MARKETER");
        }

        // Password validation intentionally skipped
        // (as per instructions)

        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}
