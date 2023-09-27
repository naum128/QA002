package com.example.qa2.service;

import com.example.qa2.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, String newName);

    void deleteUser(Long id);
}