package com.example.tictactoe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tictactoe.dto.UserRegisterDto;
import com.example.tictactoe.entity.User;
import com.example.tictactoe.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthContronller {

    private final UserRepository userRepository;

    AuthContronller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRegisterDto dto) {

        User user = new User();
        user.setFullname(dto.getFullname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        userRepository.save(user);
        return "Dang ky thanh cong";
    }

}
