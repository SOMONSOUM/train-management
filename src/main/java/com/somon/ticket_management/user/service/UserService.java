package com.somon.ticket_management.user.service;


import com.somon.ticket_management.user.dto.SignupDTO;
import com.somon.ticket_management.user.exception.UserAlreadyExistsException;
import com.somon.ticket_management.user.model.User;
import com.somon.ticket_management.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    // ---------------- SIGNUP ----------------
    public User signUp(SignupDTO request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        String hashed = passwordEncoder.encode(request.getPassword());
        request.setPassword(hashed);
        return userRepository.save(User.fromDTO(request));
    }
}
