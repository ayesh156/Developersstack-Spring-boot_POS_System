package com.pos.system.repository;

import com.pos.system.entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface RefundRepo extends JpaRepository<Refund,String> {
}
