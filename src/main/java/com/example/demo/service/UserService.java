package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    // Create a new user
    User createUser(User user);

    // Get user by ID
    Optional<User> getUserById(Long id);

    // Get all users
    List<User> getAllUsers();

    // Update a user
    User updateUser(Long id, User user);

    // Delete a user
    void deleteUser(Long id);
}
