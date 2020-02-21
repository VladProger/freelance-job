package com.jobfreelance.controller;

import com.jobfreelance.dto.RoleDto;
import com.jobfreelance.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("{id}")
    public RoleDto getRole(@PathVariable(name = "id") Integer id){
        return roleService.getRoleById(id);
    }
}
