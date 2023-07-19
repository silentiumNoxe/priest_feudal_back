package com.project.auth.controller;

import com.project.auth.dto.request.AuthRequest;
import com.project.auth.dto.request.CreateUserRequest;
import com.project.auth.dto.response.AuthResponse;
import com.project.auth.dto.response.AuthResponse.AuthResult;
import com.project.auth.dto.response.CreateUserResponse;
import com.project.auth.entity.User;
import com.project.auth.repository.UserRepository;
import com.project.auth.service.AuthService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody AuthRequest authRequest) {
       return ResponseEntity
               .status(200)
               .body(authService.signin(authRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<CreateUserResponse> signup(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity
                .status(201)
                .body(authService.signup(createUserRequest));
    }

    @GetMapping("/user")
    public ResponseEntity<User> getByEmail(@PathParam("email") String email) {
        return ResponseEntity
                .status(200)
                .body(userRepository.findByEmail(email));
    }
}
