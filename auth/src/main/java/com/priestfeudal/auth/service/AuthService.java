package com.priestfeudal.auth.service;

import com.priestfeudal.auth.dto.UserDTO;
import com.priestfeudal.auth.dto.request.CreateUserRequest;
import com.priestfeudal.auth.dto.response.CreateUserResponse;
import com.priestfeudal.auth.exception.PasswordsMismatchException;
import com.priestfeudal.auth.config.security.JwtUtils;
import com.priestfeudal.auth.dto.request.AuthRequest;
import com.priestfeudal.auth.dto.response.AuthResponse;
import com.priestfeudal.auth.entity.Role;
import com.priestfeudal.auth.entity.User;
import com.priestfeudal.auth.exception.UserAlreadyExistsException;
import com.priestfeudal.auth.exception.UserNotFoundException;
import com.priestfeudal.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static com.priestfeudal.auth.dto.response.AuthResponse.AuthResult.*;
import static com.priestfeudal.auth.dto.response.CreateUserResponse.CreateUserResult.USER_CREATE_SUCCESS;
import static com.priestfeudal.auth.entity.Role.RoleType.USER_PLAYER;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthResponse signin(AuthRequest authRequest) {
        try {
            User user = userRepository.findByEmail(authRequest.getEmail().trim()).orElseThrow(() ->
                    new UserNotFoundException(authRequest.getEmail())
            );

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getId(), authRequest.getPassword().trim())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            return new AuthResponse(AUTH_SUCCESS, jwt,
                    new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getRoles(), user.getCreatedAt())
            );
        } catch (AuthenticationException e) {
            log.error("{}", e.getMessage());
            throw e;
        }
    }

    public CreateUserResponse signup(CreateUserRequest request) {
        if (!request.getPassword().equals(request.getRepeatPassword())) {
            throw new PasswordsMismatchException();
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(request.getEmail());
        }
        User user = new User(UUID.randomUUID(),request.getUsername(),
                request.getEmail(), passwordEncoder.encode(request.getPassword().trim()),
                request.getRoles(), true, LocalDateTime.now(), LocalDateTime.now()
        );
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(Set.of(new Role(2, USER_PLAYER)));
        }
        userRepository.save(user);

        return new CreateUserResponse(USER_CREATE_SUCCESS,
                new UserDTO(user.getId(), user.getUsername(),
                        user.getEmail(), user.getRoles(), user.getCreatedAt())
        );
    }
}
