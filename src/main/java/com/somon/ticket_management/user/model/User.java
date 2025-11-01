package com.somon.ticket_management.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.somon.ticket_management.common.model.BaseModel;
import com.somon.ticket_management.user.dto.SignupDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends BaseModel {
    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotEmpty
    @Size(min = 5, max = 100)
    private String email;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$")
    @Size(min = 6, max = 100)
    @JsonIgnore
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

    // ---------------- FROM DTO ----------------
    public static User fromDTO(SignupDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
