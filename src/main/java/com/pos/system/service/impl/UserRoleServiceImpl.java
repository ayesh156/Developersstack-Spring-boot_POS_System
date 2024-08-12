package com.pos.system.service.impl;

import com.pos.system.entity.UserRole;
import com.pos.system.repository.UserRoleRepo;
import com.pos.system.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepo userRoleRepo;

    @Override
    public void initializeRoles() {
        List<UserRole> all = userRoleRepo.findAll();
        if(all.isEmpty()){
            UserRole admin = UserRole.builder().roleId(UUID.randomUUID().toString()).role("ADMIN").build();

            UserRole user = UserRole.builder().roleId(UUID.randomUUID().toString()).role("USER").build();

            userRoleRepo.saveAll(List.of(admin,user));
        }
        
    }
}
