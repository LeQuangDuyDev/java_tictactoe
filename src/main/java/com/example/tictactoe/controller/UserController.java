package com.example.tictactoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.tictactoe.entity.User;
import com.example.tictactoe.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
