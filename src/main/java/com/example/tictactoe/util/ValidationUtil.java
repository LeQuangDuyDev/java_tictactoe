package com.example.tictactoe.util;

import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.tictactoe.repository.UserRepository;

@Component
public class ValidationUtil {

    @Autowired
    private UserRepository userRepository;
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean isValidUsername(String fullname) {
        return fullname != null && fullname.length() >= 3 && fullname.length() <= 20
                && fullname.matches("^[a-zA-Z0-9_]+$");
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 6 && password.length() <= 100;
    }

    public String validateRegistration(String fullname, String email, String password,
            String confirmPassword) {
        if (fullname == null || fullname.trim().isEmpty()) {
            return "Vui lòng nhập họ và tên";
        }

        if (email == null || email.trim().isEmpty()) {
            return "Email không được để trống";
        }

        if (!isValidEmail(email)) {
            return "Định dạng email không hợp lệ";
        }

        if (userRepository.existsByEmail(email)) {
            return "Email đã được đăng ký";
        }

        if (password == null || password.trim().isEmpty()) {
            return "Mật khẩu không được để trống";
        }

        if (!isValidPassword(password)) {
            return "Mật khẩu phải từ 6-100 ký tự";
        }

        if (!password.equals(confirmPassword)) {
            return "Mật khẩu xác nhận không khớp";
        }

        return null;
    }
}
