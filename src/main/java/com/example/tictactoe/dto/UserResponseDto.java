package com.example.tictactoe.dto;

import java.time.LocalDateTime;

public class UserResponseDto {
    private String fullname;
    private String email;
    private LocalDateTime createdAt;

    public UserResponseDto(String fullname, String email, LocalDateTime createdAt) {
        this.fullname = fullname;
        this.email = email;
        this.createdAt = createdAt;
    }

    // Getters
    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
