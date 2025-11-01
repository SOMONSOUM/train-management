package com.somon.ticket_management.user;

import com.somon.ticket_management.user.dto.SignupDto;
import com.somon.ticket_management.user.exception.UserAlreadyExistsException;
import com.somon.ticket_management.user.model.User;
import com.somon.ticket_management.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ---------------- SIGNUP ----------------
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignupDto request){
        try {
            User savedUser = userService.signUp(request);
            return ResponseEntity.ok(savedUser);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
