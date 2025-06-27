package com.example.tictactoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tictactoe.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}