package com.pos.system.repository;


import com.pos.system.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface ApplicationUserRepo extends JpaRepository<ApplicationUser,String> {
    public Optional<ApplicationUser> findByUsername(String username);
}
