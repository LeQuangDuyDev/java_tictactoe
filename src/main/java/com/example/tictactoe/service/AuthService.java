package com.example.tictactoe.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.tictactoe.repository.UserRepository;
import com.example.tictactoe.util.PasswordUtil;
import com.example.tictactoe.util.ValidationUtil;
import com.example.tictactoe.dto.AuthResponse;
import com.example.tictactoe.dto.LoginRequest;
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
        // System.out.println("Đã vào register service");
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

    public AuthResponse login(LoginRequest request) {
        try {
            // Validate input
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                return new AuthResponse(false, "Username/Email không được để trống");
            }

            if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
                return new AuthResponse(false, "Mật khẩu không được để trống");
            }

            // Find user by username or email
            Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

            if (!userOptional.isPresent()) {
                return new AuthResponse(false, "Tài khoản không tồn tại");
            }

            User user = userOptional.get();

            // Verify password
            // if (!passwordUtil.verifyPassword(request.getPassword(), user.getPassword())) {
            // return new AuthResponse(false, "Mật khẩu không chính xác");
            // }

            // if (request.getPassword() != user.getPassword()) {
            //     return new AuthResponse(false, "Mật khẩu không chính xác");
            // }

            // Don't return password in response
            user.setPassword(null);

            return new AuthResponse(true, "Đăng nhập thành công", user);

        } catch (Exception e) {
            return new AuthResponse(false, "Có lỗi xảy ra: " + e.getMessage());
        }
    }
}
