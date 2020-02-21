package com.jobfreelance.service;

import com.jobfreelance.dto.RoleDto;
import com.jobfreelance.entity.RoleEntity;
import com.jobfreelance.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleDto getRoleById(Integer id){
        RoleEntity entity = roleRepository.findById(id).orElse(new RoleEntity());
        return new RoleDto(entity.getId(), entity.getRoleName());
    }
}
