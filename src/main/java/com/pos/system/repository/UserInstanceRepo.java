package com.pos.system.repository;

import com.pos.system.entity.UserInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserInstanceRepo extends JpaRepository<UserInstance,String> {
}
