package com.pos.system.repository;

import com.pos.system.entity.LoyaltyCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface LoyaltyCardRepo  extends JpaRepository<LoyaltyCard, String> {
}
