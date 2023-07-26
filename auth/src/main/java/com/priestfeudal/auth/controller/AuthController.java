package com.priestfeudal.auth.controller;

import com.priestfeudal.auth.dto.request.AuthRequest;
import com.priestfeudal.auth.dto.request.CreateUserRequest;
import com.priestfeudal.auth.dto.response.AuthResponse;
import com.priestfeudal.auth.dto.response.CreateUserResponse;
import com.priestfeudal.auth.exception.UserNotFoundException;
import com.priestfeudal.auth.service.AuthService;
import com.priestfeudal.auth.entity.User;
import com.priestfeudal.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyAuthority('USER_PLAYER')")
    @GetMapping("/user/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email) {
        return ResponseEntity
                .status(200)
                .body(userRepository.findByEmail(email).orElseThrow(() ->
                        new UserNotFoundException(email))
                );
    }
}
