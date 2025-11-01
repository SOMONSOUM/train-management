package com.somon.ticket_management.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SignupDto {
    @Email()
    @Size(min = 5, max = 100)
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 6, max = 100, message = "Password must be at least 5 characters long")
    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", message = "Password must be at least 6 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
