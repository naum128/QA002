package com.example.qa2.controller;

import com.example.qa2.entity.User;
import com.example.qa2.repository.UserRepository;
import com.example.qa2.service.UserService;
import com.example.qa2.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    public  ResponseEntity<?> createUser(@RequestParam String name) {
        User newUser = userServiceImpl.createUser(name);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<?>> getAllUsers() {
        List<User> users = userServiceImpl.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userServiceImpl.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestParam String user) {
        User updatedUser = userServiceImpl.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}