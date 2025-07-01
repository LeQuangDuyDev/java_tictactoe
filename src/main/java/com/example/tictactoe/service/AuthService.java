package com.example.tictactoe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.tictactoe.repository.UserRepository;
import com.example.tictactoe.util.PasswordUtil;
import com.example.tictactoe.util.ValidationUtil;
import com.example.tictactoe.dto.AuthResponse;
import com.example.tictactoe.dto.RegisterRequest;
import com.example.tictactoe.entity.User;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordUtil passwordUtil;

    @Autowired
    private ValidationUtil validationUtil;

    public AuthResponse register(RegisterRequest request) {
        System.out.println("Đã vào register service");
        try {
            String validationError = validationUtil.validateRegistration(request.getFullname(),
                    request.getEmail(), request.getPassword(), request.getConfirmPassword());

            if (validationError != null) {
                return new AuthResponse(false, validationError);
            }

            // Check if email exists
            if (userRepository.existsByEmail(request.getEmail())) {
                return new AuthResponse(false, "Email đã tồn tại");
            }

            // Create new user
            String hashedPassword = passwordUtil.hashPassword(request.getPassword());
            User user = new User(request.getFullname(), request.getEmail(), hashedPassword);

            User savedUser = userRepository.save(user);

            // Don't return password in response
            savedUser.setPassword(null);

            return new AuthResponse(true, "Đăng ký thành công", savedUser);
        } catch (Exception e) {
            return new AuthResponse(false, "Có lỗi xảy ra: " + e.getMessage());
        }
    }
}
