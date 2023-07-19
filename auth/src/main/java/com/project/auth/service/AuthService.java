package com.project.auth.service;

import com.project.auth.config.security.JwtUtils;
import com.project.auth.dto.request.AuthRequest;
import com.project.auth.dto.request.CreateUserRequest;
import com.project.auth.dto.response.AuthResponse;
import com.project.auth.dto.response.CreateUserResponse;
import com.project.auth.entity.Role;
import com.project.auth.entity.User;
import com.project.auth.exception.PasswordsMismatchException;
import com.project.auth.exception.UserAlreadyExistsException;
import com.project.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

import static com.project.auth.dto.mapper.UserMapper.convertCreateRequestToUser;
import static com.project.auth.dto.mapper.UserMapper.convertUserToUserDTO;
import static com.project.auth.dto.response.AuthResponse.AuthResult.*;
import static com.project.auth.dto.response.CreateUserResponse.CreateUserResult.USER_CREATE_ERROR;
import static com.project.auth.dto.response.CreateUserResponse.CreateUserResult.USER_CREATE_SUCCESS;
import static com.project.auth.entity.Role.RoleType.USER_PLAYER;

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
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail().trim(), authRequest.getPassword().trim())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            User user = userRepository.findByEmail(authRequest.getEmail().trim());
            return new AuthResponse(AUTH_SUCCESS, jwt, convertUserToUserDTO(user));
        } catch (AuthenticationException e) {
            log.error("{}", e.getMessage());
            return new AuthResponse(AUTH_FAILED, null, null);
        }
    }

    public CreateUserResponse signup(CreateUserRequest request) {
        if (!request.getPassword().equals(request.getRepeatPassword())) {
            return new CreateUserResponse(USER_CREATE_ERROR,
                    new PasswordsMismatchException(), null);
        }
        if (userRepository.existsByEmail(request.getEmail())) {
           return new CreateUserResponse(USER_CREATE_ERROR,
                   new UserAlreadyExistsException(request.getEmail()), null);
        }
        User user = convertCreateRequestToUser(request);
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(Set.of(new Role(2, USER_PLAYER)));
        }
        user.setPassword(passwordEncoder.encode(request.getPassword().trim()));
        user.setId(UUID.randomUUID());
        userRepository.save(user);
        return new CreateUserResponse(USER_CREATE_SUCCESS, null,
                convertUserToUserDTO(user));
    }
}
