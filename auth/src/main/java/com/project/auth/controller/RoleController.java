package com.project.auth.controller;

import com.project.auth.dto.request.CreateRoleRequest;
import com.project.auth.entity.Role;
import com.project.auth.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/role")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody CreateRoleRequest request) {
        return ResponseEntity
                .status(200)
                .body(roleService.saveRole(request));
    }
}
