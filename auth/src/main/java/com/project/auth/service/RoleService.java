package com.project.auth.service;

import com.project.auth.dto.request.CreateRoleRequest;
import com.project.auth.entity.Role;
import com.project.auth.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role saveRole(CreateRoleRequest request) {
        return roleRepository.save(new Role(request.getId(), request.getRoleType()));
    }
}
