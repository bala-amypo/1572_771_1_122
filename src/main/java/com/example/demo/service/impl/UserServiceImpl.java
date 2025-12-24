package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> existing = getUserById(id);
        if (existing.isPresent()) {
            users.remove(existing.get());
            users.add(user);
            return user;
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        users.removeIf(u -> u.getId().equals(id));
    }
}
