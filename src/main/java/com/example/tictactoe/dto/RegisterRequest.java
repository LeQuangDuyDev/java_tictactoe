package com.example.tictactoe.dto;

public class RegisterRequest {
    private String fullname;
    private String email;
    private String password;
    private String confirmPassword;

    public RegisterRequest() {}

    public RegisterRequest(String fullname, String email, String password, String confirmPassword) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    // get set
    // name
    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    // email
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // password
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // confirm password
    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
