package com.project.auth.dto.mapper;

import com.project.auth.dto.UserDTO;
import com.project.auth.dto.request.CreateUserRequest;
import com.project.auth.entity.User;

import java.time.LocalDateTime;

public class UserMapper {

    public static UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setRoles(user.getRoles());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }

    public static User convertCreateRequestToUser(CreateUserRequest dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}
