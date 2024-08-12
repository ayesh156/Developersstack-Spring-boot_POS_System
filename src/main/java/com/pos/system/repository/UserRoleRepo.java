package com.pos.system.repository;

import com.pos.system.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserRoleRepo  extends JpaRepository<UserRole,String> {
}
